package com.july.pet.entity;

import com.july.pet.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDO extends BaseDO {

    private String nickName;

    private String brand;

    private Boolean gender;

    private Integer children;

    private Integer vaccine;

    private Boolean repellent;

    private Boolean sterilization;

    private Boolean bear;

    private String imgUrls;

}