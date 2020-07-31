package com.july.pet.entity;

import com.july.pet.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDO extends BaseDO {

    private String nickName;

    private String avatar;

    private String wxNum;

    private String phone;
}