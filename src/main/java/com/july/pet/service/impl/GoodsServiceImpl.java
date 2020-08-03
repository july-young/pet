package com.july.pet.service.impl;

import com.july.pet.bo.GoodsBO;
import com.july.pet.common.BaseService;
import com.july.pet.common.PetExceptionEnum;
import com.july.pet.common.PetPage;
import com.july.pet.converter.GoodsConverter;
import com.july.pet.dao.GoodsMapper;
import com.july.pet.dto.QueryGoodsDTO;
import com.july.pet.entity.GoodsDO;
import com.july.pet.entity.GoodsExample;
import com.july.pet.exception.PetException;
import com.july.pet.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 09:20
 * @description:
 */
@Service
public class GoodsServiceImpl extends BaseService<GoodsBO, GoodsDO, GoodsConverter, GoodsMapper> implements GoodsService {
    @Override
    public GoodsBO query(Long id) {
        return this.findById(id);
    }

    @Override
    public GoodsBO query(String code) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andCodeEqualTo(code);
        List<GoodsBO> list = list(goodsExample);
        int size = list.size();
        if (size > 1) {
            throw new PetException(PetExceptionEnum.DATA_DUPLICATE);
        }
        return size > 0 ? list.get(0) : null;
    }

    @Override
    public PetPage<GoodsBO> query(QueryGoodsDTO dto) {
        return page(new GoodsExample(), dto.getPage(), dto.getSize());
    }

    @Override
    public List<GoodsBO> query(List<Long> ids) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdIn(ids);
        return list(goodsExample);
    }

    @Override
    public GoodsBO create(GoodsBO petBO) {
        return add(petBO);
    }

    @Override
    public GoodsBO update(GoodsBO petBO) {
        return modify(petBO);
    }
}
