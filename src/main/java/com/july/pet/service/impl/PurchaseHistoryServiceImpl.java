package com.july.pet.service.impl;

import com.july.pet.bo.GoodsBO;
import com.july.pet.bo.GoodsItemBO;
import com.july.pet.bo.PurchaseHistoryBO;
import com.july.pet.common.BaseService;
import com.july.pet.common.PetExceptionEnum;
import com.july.pet.common.PetPage;
import com.july.pet.converter.PurchaseHistoryConverter;
import com.july.pet.dao.PurchaseHistoryMapper;
import com.july.pet.dto.QueryPurchaseHistoryDTO;
import com.july.pet.entity.PurchaseHistoryDO;
import com.july.pet.entity.PurchaseHistoryExample;
import com.july.pet.exception.PetException;
import com.july.pet.service.GoodsItemService;
import com.july.pet.service.GoodsService;
import com.july.pet.service.PurchaseHistoryService;
import com.july.pet.util.KeyUtil;
import com.july.pet.util.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 14:49
 * @description:
 */
@Service
public class PurchaseHistoryServiceImpl extends BaseService<PurchaseHistoryBO, PurchaseHistoryDO, PurchaseHistoryConverter, PurchaseHistoryMapper> implements PurchaseHistoryService {


    @Autowired
    private GoodsItemService goodsItemService;

    @Autowired
    private GoodsService goodsService;

    @Override
    public PetPage<PurchaseHistoryBO> query(QueryPurchaseHistoryDTO dto) {

        PurchaseHistoryExample purchaseHistoryExample = new PurchaseHistoryExample();
        purchaseHistoryExample.createCriteria().andUserIdEqualTo(UserInfoUtil.getUserId());
        return page(purchaseHistoryExample, dto.getPage(), dto.getSize());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PurchaseHistoryBO create(PurchaseHistoryBO bo) {

        GoodsBO bGoodsBO = bo.getGoodsBO();
        String goodsCode = KeyUtil.generateGoodsCode(bGoodsBO);

        GoodsBO goodsBO = goodsService.query(goodsCode);
        if (goodsBO == null) {
            bGoodsBO.setCode(goodsCode);
            goodsBO = goodsService.create(bGoodsBO);
            bo.setGoodsId(goodsBO.getId());
        }
        Long userId = UserInfoUtil.getUserId();

        bo.setUserId(userId);
        PurchaseHistoryBO purchaseHistoryBO = this.add(bo);
        //下发Item
        List<GoodsItemBO> goodsItemCreateList = new ArrayList<>(bo.getAmount());
        for (int i = 0, len = bo.getAmount(); i < len; i++) {
            GoodsItemBO goodsItemBO = new GoodsItemBO();
            goodsItemBO.setChannel(bo.getChannel());
            goodsItemBO.setGmtExpire(bo.getGmtExpire());
            goodsItemBO.setGmtBuy(bo.getGmtBuy());
            goodsItemBO.setGoodsId(goodsBO.getId());
            goodsItemBO.setPrice(bo.getPrice());
            goodsItemBO.setUserId(userId);
            goodsItemBO.setGoodsId(bo.getGoodsId());
            goodsItemBO.setHistoryId(purchaseHistoryBO.getGoodsId());
            goodsItemCreateList.add(goodsItemBO);
        }

        goodsItemService.create(goodsItemCreateList);

        return purchaseHistoryBO;
    }

    @Override
    public List<GoodsItemBO> queryGoodsItems(Long id) {

        return goodsItemService.queryByHistoryId(id);
    }

    @Override
    public void computeLeftDays() {
        //todo
        //1、查出最近的商品开袋信息
        //2、gmtOpen - gmtLast 计算时间
        //3、计算每日消耗量
        //4、求出天数写入数据库
        //5、展示天数计算交给前端，减轻服务器压力（gmtOpen + 天数 - now）
    }
}
