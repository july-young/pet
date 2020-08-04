package com.july.pet.service;

import com.july.pet.bo.GoodsItemBO;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryGoodsItemDTO;

import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 12:28
 * @description:
 */
public interface GoodsItemService {
    GoodsItemBO query(Long id);

    PetPage<GoodsItemBO> query(QueryGoodsItemDTO dto);

    GoodsItemBO create(GoodsItemBO petBO);

    GoodsItemBO update(GoodsItemBO petBO);

    int remove(long id);

    void create(List<GoodsItemBO> goodsItemCreateList);

    List<GoodsItemBO>  queryByHistoryId(Long id);

    GoodsItemBO openGoodsItem(Long id, Date openDate);
}
