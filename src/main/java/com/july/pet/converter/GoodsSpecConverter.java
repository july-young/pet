package com.july.pet.converter;

import com.july.pet.bo.GoodsSpecBO;
import com.july.pet.common.BaseConverter;
import com.july.pet.entity.GoodsSpecDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/8/3 09:38
 * @description:
 */
@Component
public class GoodsSpecConverter implements BaseConverter<GoodsSpecBO,GoodsSpecDO> {

    @Override
    public GoodsSpecBO toBO(GoodsSpecDO d) {
        GoodsSpecBO goodsSpecBO = new GoodsSpecBO();
        goodsSpecBO.setKey(d.getCode());
        goodsSpecBO.setValue(d.getName());
        return goodsSpecBO;
    }

    @Override
    public GoodsSpecDO toDO(GoodsSpecBO b) {
        GoodsSpecDO goodsSpecDO = new GoodsSpecDO();
        goodsSpecDO.setCode(b.getKey());
        goodsSpecDO.setName(b.getValue());
        return goodsSpecDO;
    }
}
