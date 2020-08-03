package com.july.pet.service.impl;

import com.july.pet.bo.GoodsItemBO;
import com.july.pet.common.BaseService;
import com.july.pet.common.PetPage;
import com.july.pet.converter.GoodsItemConverter;
import com.july.pet.dao.GoodsItemMapper;
import com.july.pet.dto.QueryGoodsItemDTO;
import com.july.pet.entity.GoodsItemDO;
import com.july.pet.entity.GoodsItemExample;
import com.july.pet.service.GoodsItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 12:28
 * @description:
 */
@Service
public class GoodsItemServiceImpl extends BaseService<GoodsItemBO,GoodsItemDO,GoodsItemConverter,GoodsItemMapper> implements GoodsItemService {


    @Override
    public GoodsItemBO query(Long id ) {
        return this.findById(id);
    }


    @Override
    public PetPage<GoodsItemBO> query(QueryGoodsItemDTO dto) {

        return this.page(new GoodsItemExample(),dto.getPage(),dto.getSize());
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

}
