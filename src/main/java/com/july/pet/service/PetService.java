package com.july.pet.service;

import com.july.pet.bo.PetBO;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryPetDTO;

/**
 * @author: july
 * @date: 2020/7/31 18:31
 * @description:
 */
public interface PetService {

    PetBO query(Long id);

    PetPage<PetBO> query(QueryPetDTO dto);

    PetBO create(PetBO petBO);

    PetBO update(PetBO petBO);

    int remove(long id);

}
