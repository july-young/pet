package com.july.pet.converter;

import com.july.pet.bo.UserBO;
import com.july.pet.common.BaseConverter;
import com.july.pet.common.PetExceptionEnum;
import com.july.pet.entity.UserDO;
import com.july.pet.exception.PetException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/7/31 10:50
 * @description:
 */
@Component
public class UserConverter implements BaseConverter<UserBO, UserDO> {

    @Override
    public UserBO toBO(UserDO d) {
        if (d == null) {
            return null;
        }
        UserBO bo = new UserBO();
        BeanUtils.copyProperties(d, bo);
        return bo;
    }

    @Override
    public UserDO toDO(UserBO b) {
        if(b==null){
            throw new PetException(PetExceptionEnum.DATA_NOT_BE_NULL);
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(b, userDO);
        return userDO;
    }
}
