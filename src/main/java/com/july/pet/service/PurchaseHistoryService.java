package com.july.pet.service;

import com.july.pet.bo.PurchaseHistoryBO;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryPurchaseHistoryDTO;

/**
 * @author: july
 * @date: 2020/8/3 14:47
 * @description:
 */
public interface PurchaseHistoryService {

    PetPage<PurchaseHistoryBO> query(QueryPurchaseHistoryDTO dto);

    PurchaseHistoryBO create(PurchaseHistoryBO bo);

}
