package com.july.pet.service;

import com.july.pet.bo.GoodsItemBO;
import com.july.pet.bo.PurchaseHistoryBO;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryPurchaseHistoryDTO;

import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 14:47
 * @description:
 */
public interface PurchaseHistoryService {

    PetPage<PurchaseHistoryBO> query(QueryPurchaseHistoryDTO dto);

    PurchaseHistoryBO create(PurchaseHistoryBO bo);

    /**
     * 查询某条记录下的所有商品
     * @param id
     * @return
     */
    List<GoodsItemBO> queryGoodsItems(Long id);

    /**
     * 查询某条记录下的所有商品
     * @param id
     * @return
     */
    void computeLeftDays();
}
