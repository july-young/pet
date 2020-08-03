package com.july.pet.bo;

import com.july.pet.common.BaseBO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 09:18
 * @description:
 */
@Getter
@Setter
public class GoodsBO extends BaseBO {

    private String code;

    private String name;

    private String brand;

    private String category;

    private Integer weight;

    private String speciality;

    private List<String> imgUrls;

}
