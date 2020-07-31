package com.july.pet.common;

/**
 * @author: july
 * @date: 2020/7/31 12:18
 * @description:
 */
public abstract class AbstractForm<BO> extends ToString{
    /**
     * 转为BO
     * @return
     */
    public abstract BO toBO();
}
