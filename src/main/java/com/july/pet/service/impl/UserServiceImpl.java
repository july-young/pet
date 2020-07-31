package com.july.pet.service.impl;

import com.july.pet.bo.UserBO;
import com.july.pet.common.BaseService;
import com.july.pet.common.PetPage;
import com.july.pet.converter.UserConverter;
import com.july.pet.dao.UserMapper;
import com.july.pet.dto.QueryUserDTO;
import com.july.pet.entity.UserDO;
import com.july.pet.entity.UserExample;
import com.july.pet.service.UserService;
import org.springframework.stereotype.Service;


/**
 * @author: july
 * @date: 2020/7/31 11:03
 * @description:
 */
@Service
public class UserServiceImpl extends BaseService<UserBO, UserDO, UserConverter, UserMapper> implements UserService {

    @Override
    public UserBO create(UserBO userBO) {

        return add(userBO);
    }

    @Override
    public UserBO update(UserBO userBO) {

        return modify(userBO);
    }

    @Override
    public PetPage<UserBO> query(QueryUserDTO dto) {

        return page(new UserExample(), dto.getPage(), dto.getSize());
    }
}
