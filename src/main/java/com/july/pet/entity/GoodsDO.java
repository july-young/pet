package com.july.pet.entity;

import com.july.pet.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsDO extends BaseDO {

    private String code;

    private String name;

    private String brand;

    private String category;

    private Integer weight;

    private String speciality;

    private String imgUrls;

}