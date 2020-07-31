package com.july.pet.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: july
 * @date: 2020/7/31 16:47
 * @description:
 */

@Getter
@Setter
public class BaseQueryPageDTO extends ToString {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 页数
     */
    private Integer size;


}
