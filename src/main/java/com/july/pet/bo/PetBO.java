package com.july.pet.bo;

import com.july.pet.common.BaseBO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: july
 * @date: 2020/7/31 18:45
 * @description:
 */
@Getter
@Setter
public class PetBO extends BaseBO {

    private String nickName;

    private String brand;

    private Boolean gender;

    private Integer children;

    private Integer vaccine;

    private Boolean repellent;

    private Boolean sterilization;

    private Boolean bear;

    private List<String> imgUrlList;
}
