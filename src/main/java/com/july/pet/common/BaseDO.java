package com.july.pet.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: july
 * @date: 2020/7/31 14:15
 * @description:
 */
@Getter
@Setter
public class BaseDO {

    private Long id;

    private Date gmtCreate;

    private Date gmtUpdate;

    private Long creator;

    private Long updater;

    private Boolean deleted;

}
