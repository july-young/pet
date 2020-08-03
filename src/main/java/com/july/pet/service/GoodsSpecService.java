package com.july.pet.service;

import com.july.pet.bo.GoodsSpecBO;

import java.util.List;
import java.util.Map;

/**
 * @author: july
 * @date: 2020/8/3 09:36
 * @description:
 */
public interface GoodsSpecService {

    String querySpec(String key);

    Map<String,String> querySpecs(String setName);
}
