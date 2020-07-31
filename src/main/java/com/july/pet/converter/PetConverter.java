package com.july.pet.converter;

import com.alibaba.fastjson.JSON;
import com.july.pet.bo.PetBO;
import com.july.pet.common.BaseConverter;
import com.july.pet.entity.PetDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author: july
 * @date: 2020/7/31 18:54
 * @description:
 */
@Component
public class PetConverter implements BaseConverter<PetBO, PetDO> {

    @Override
    public PetBO toBO(PetDO d) {
        PetBO petBO = new PetBO();
        BeanUtils.copyProperties(d, petBO);
        petBO.setImgUrlList(JSON.parseArray(d.getImgUrls(), String.class));
        return petBO;
    }

    @Override
    public PetDO toDO(PetBO b) {
        PetDO petDO = new PetDO();
        BeanUtils.copyProperties(b, petDO);
        petDO.setImgUrls(JSON.toJSONString(b.getImgUrlList()));
        return petDO;
    }
}
