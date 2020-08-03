package com.july.pet.service.impl;

import com.july.pet.bo.GoodsSpecBO;
import com.july.pet.common.BaseService;
import com.july.pet.converter.GoodsSpecConverter;
import com.july.pet.dao.GoodsSpecMapper;
import com.july.pet.entity.GoodsSpecDO;
import com.july.pet.entity.GoodsSpecExample;
import com.july.pet.service.GoodsSpecService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: july
 * @date: 2020/8/3 09:51
 * @description:
 */
@Service
public class GoodsSpecServiceImpl extends BaseService<GoodsSpecBO, GoodsSpecDO, GoodsSpecConverter, GoodsSpecMapper> implements GoodsSpecService {

    @Override
    public String querySpec(String key) {
        //todo 加入缓存
        GoodsSpecExample goodsSpecExample = new GoodsSpecExample();
        goodsSpecExample.createCriteria().andCodeEqualTo(key).andDeletedEqualTo(false);
        List<GoodsSpecBO> list = this.list(goodsSpecExample);
        return CollectionUtils.isEmpty(list) ? null : list.get(0).getValue();
    }

    @Override
    public Map<String, String> querySpecs(String setName) {

        GoodsSpecExample goodsSpecExample = new GoodsSpecExample();
        goodsSpecExample.createCriteria().andCateEqualTo(setName).andDeletedEqualTo(false);

        List<GoodsSpecBO> list = this.list(goodsSpecExample);
        Map<String, String> map = new HashMap(list.size() * 2);
        list.forEach(x -> {
            map.put(x.getKey(), x.getValue());
        });
        return map;
    }
}
