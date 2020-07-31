package com.july.pet.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/7/31 11:04
 * @description: spring 容器工具类
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    /**
     * spring 上下文
     */
    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 根据类型在spring 容器中获取bean
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }

    /**
     * 根据名称在spring 容器中获取bean
     *
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}
