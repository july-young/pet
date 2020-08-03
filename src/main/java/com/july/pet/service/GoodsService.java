package com.july.pet.service;

import com.july.pet.bo.GoodsBO;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryGoodsDTO;

import java.util.Collection;
import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 09:17
 * @description:
 */
public interface GoodsService {

    GoodsBO query(Long id);

    GoodsBO query(String code);

    PetPage<GoodsBO> query(QueryGoodsDTO dto);

    List<GoodsBO> query( List<Long> ids);

    GoodsBO create(GoodsBO petBO);

    GoodsBO update(GoodsBO petBO);

    int remove(long id);
}
