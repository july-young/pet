package com.july.pet.service.impl;

import com.july.pet.bo.GoodsItemBO;
import com.july.pet.common.BaseService;
import com.july.pet.common.PetExceptionEnum;
import com.july.pet.common.PetPage;
import com.july.pet.converter.GoodsItemConverter;
import com.july.pet.dao.GoodsItemMapper;
import com.july.pet.dto.QueryGoodsItemDTO;
import com.july.pet.entity.GoodsItemDO;
import com.july.pet.entity.GoodsItemExample;
import com.july.pet.exception.PetException;
import com.july.pet.service.GoodsItemService;
import com.july.pet.util.DateUtil;
import com.july.pet.util.UserInfoUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/8/3 12:28
 * @description:
 */
@Service
public class GoodsItemServiceImpl extends BaseService<GoodsItemBO, GoodsItemDO, GoodsItemConverter, GoodsItemMapper> implements GoodsItemService {


    @Override
    public GoodsItemBO query(Long id) {
        return this.findById(id);
    }


    @Override
    public PetPage<GoodsItemBO> query(QueryGoodsItemDTO dto) {
        PetPage<GoodsItemBO> page = this.page(new GoodsItemExample(), dto.getPage(), dto.getSize());
        //todo 计算剩余天数
        return page;
    }

    @Override
    public GoodsItemBO create(GoodsItemBO petBO) {
        return this.add(petBO);
    }

    @Override
    public GoodsItemBO update(GoodsItemBO petBO) {
        return null;
    }

    @Override
    public void create(List<GoodsItemBO> list) {
        for (GoodsItemBO goodsItemBO : list) {
            create(goodsItemBO);
        }
    }

    @Override
    public List<GoodsItemBO> queryByHistoryId(Long id) {

        GoodsItemExample goodsItemExample = new GoodsItemExample();
        goodsItemExample.createCriteria().andHistoryIdEqualTo(id);
        return this.list(goodsItemExample);
    }

    @Override
    public GoodsItemBO openGoodsItem(Long id, Date openDate) {
        Date now = new Date();
        openDate = openDate == null ? now : openDate;
        GoodsItemBO goodsItemBO = new GoodsItemBO();
        goodsItemBO.setId(id);
        goodsItemBO.setGmtOpen(openDate);

        GoodsItemBO itemBO = this.findById(id);

        Long userId = UserInfoUtil.getUserId();
        GoodsItemExample goodsItemExample = new GoodsItemExample();
        goodsItemExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andHistoryIdEqualTo(itemBO.getHistoryId());
        List<GoodsItemBO> goodsItemBOList = list(goodsItemExample);
        if (goodsItemBOList.size() < 1) {
            throw new PetException(PetExceptionEnum.DATA_NOT_EXISTS);
        }

        //同一记录的最大值
        List<GoodsItemBO> itemBOList = goodsItemBOList.stream().filter(x -> x.getGmtOpen() != null).sorted((x, y) -> x.getGmtOpen().compareTo(y.getGmtOpen())).collect(Collectors.toList());

        if (itemBOList.size() > 0) {
            Date gmtOpen = itemBOList.get(0).getGmtOpen();
            goodsItemBO.setGmtLastOpen(gmtOpen);
        } else {
            GoodsItemBO maxGmtOpenByUserId = getMaxGmtOpenByUserId(itemBO.getCategory(), itemBO.getUserId());
            if (maxGmtOpenByUserId == null) {
                goodsItemBO.setGmtLastOpen(now);
            } else {
                goodsItemBO.setGmtLastOpen(maxGmtOpenByUserId.getGmtOpen());
            }
        }

        return this.modify(goodsItemBO);
    }

    private GoodsItemBO getMaxGmtOpenByUserId(String cate, Long userId) {
        GoodsItemExample goodsItemExample = new GoodsItemExample();
        goodsItemExample.createCriteria()
                .andCategoryEqualTo(cate)
                .andUserIdEqualTo(userId);

        goodsItemExample.setOrderByClause(" gmt_open desc ");
        return one(goodsItemExample);
    }
}
