package com.july.pet.converter;

import com.alibaba.fastjson.JSON;
import com.july.pet.bo.GoodsBO;
import com.july.pet.common.BaseConverter;
import com.july.pet.entity.GoodsDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 09:22
 * @description:
 */
@Component
public class GoodsConverter implements BaseConverter<GoodsBO,GoodsDO> {

    @Override
    public GoodsBO toBO(GoodsDO d) {
        GoodsBO goodsBO = new GoodsBO();
        BeanUtils.copyProperties(d,goodsBO);
        List<String> imgUrls = JSON.parseArray(d.getImgUrls(), String.class);
        goodsBO.setImgUrls(imgUrls);
        return goodsBO;
    }

    @Override
    public GoodsDO toDO(GoodsBO b) {
        GoodsDO goodsDO = new GoodsDO();
        BeanUtils.copyProperties(b,goodsDO);
        goodsDO.setImgUrls(JSON.toJSONString(b.getImgUrls()));
        return goodsDO;
    }
}
