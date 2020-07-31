package com.july.pet.common;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author: july
 * @date: 2020/7/31 10:43
 * @description: 重写 toString
 */
public class ToString implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
