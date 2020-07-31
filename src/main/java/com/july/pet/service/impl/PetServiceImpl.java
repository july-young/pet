package com.july.pet.service.impl;

import com.july.pet.bo.PetBO;
import com.july.pet.common.BaseService;
import com.july.pet.common.PetPage;
import com.july.pet.converter.PetConverter;
import com.july.pet.dao.PetMapper;
import com.july.pet.dto.QueryPetDTO;
import com.july.pet.entity.PetDO;
import com.july.pet.entity.PetExample;
import com.july.pet.service.PetService;
import org.springframework.stereotype.Service;


/**
 * @author: july
 * @date: 2020/7/31 19:00
 * @description:
 */
@Service
public class PetServiceImpl extends BaseService<PetBO, PetDO, PetConverter, PetMapper> implements PetService {


    @Override
    public PetBO query(Long id) {
        return this.findById(id);
    }

    @Override
    public PetPage<PetBO> query(QueryPetDTO dto) {

        return this.page(new PetExample(), dto.getPage(), dto.getSize());
    }

    @Override
    public PetBO create(PetBO petBO) {
        return this.add(petBO);
    }

    @Override
    public PetBO update(PetBO petBO) {
        return this.modify(petBO);
    }

}
