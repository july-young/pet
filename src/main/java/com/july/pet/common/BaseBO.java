package com.july.pet.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: july
 * @date: 2020/7/31 10:47
 * @description: BO基类
 */
@Getter
@Setter
public class BaseBO extends ToString {
    @ApiModelProperty("数据id")
    private Long id;
}
