package com.july.pet.service;

import com.july.pet.bo.UserBO;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryUserDTO;

/**
 * @author: july
 * @date: 2020/7/31 10:59
 * @description:
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param userBO
     * @return
     */
    UserBO create(UserBO userBO);

    /**
     * 更新用户
     *
     * @param userBO
     * @return
     */
    UserBO update(UserBO userBO);

    /**
     * 分页查询用户
     * @param dto
     * @return
     */
    PetPage<UserBO> query(QueryUserDTO dto);
}
