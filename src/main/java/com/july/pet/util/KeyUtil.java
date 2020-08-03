package com.july.pet.util;

import com.july.pet.bo.GoodsBO;

/**
 * @author: july
 * @date: 2020/8/3 17:28
 * @description:
 */
public class KeyUtil {

    /**
     * 生成条码
     * @param bo
     * @return
     */
    public static String generateGoodsCode(GoodsBO bo) {

        return "gc_" + bo.getBrand() + "_" + bo.getCategory() + "_" + bo.getSpeciality() + "_" + bo.getWeight() + "_" + bo.getName();
    }


}
