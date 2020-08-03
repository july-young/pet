package com.july.pet.converter;

import com.july.pet.bo.GoodsBO;
import com.july.pet.bo.PurchaseHistoryBO;
import com.july.pet.common.BaseConverter;
import com.july.pet.entity.PurchaseHistoryDO;
import com.july.pet.service.GoodsService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/8/3 14:42
 * @description:
 */
@Slf4j
@Component
public class PurchaseHistoryConverter implements BaseConverter<PurchaseHistoryBO, PurchaseHistoryDO> {

    @Autowired
    private GoodsService goodsService;

    @Override
    public PurchaseHistoryBO toBO(PurchaseHistoryDO d) {
        PurchaseHistoryBO purchaseHistoryBO = new PurchaseHistoryBO();
        BeanUtils.copyProperties(d, purchaseHistoryBO);
        try {
            GoodsBO goodsBO = goodsService.query(d.getGoodsId());
            purchaseHistoryBO.setGoodsBO(goodsBO);
        } catch (Exception e) {
            log.error("PurchaseHistoryConverter#toBO: " + e.getMessage());
        }


        return purchaseHistoryBO;
    }

    @Override
    public PurchaseHistoryDO toDO(PurchaseHistoryBO b) {
        PurchaseHistoryDO purchaseHistoryDO = new PurchaseHistoryDO();
        BeanUtils.copyProperties(b, purchaseHistoryDO);
        return purchaseHistoryDO;
    }
}
