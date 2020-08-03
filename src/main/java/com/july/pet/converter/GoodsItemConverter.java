package com.july.pet.converter;

import com.july.pet.bo.GoodsBO;
import com.july.pet.bo.GoodsItemBO;
import com.july.pet.common.BaseConverter;
import com.july.pet.common.PetPage;
import com.july.pet.dto.QueryGoodsDTO;
import com.july.pet.entity.GoodsItemDO;
import com.july.pet.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: july
 * @date: 2020/8/3 12:35
 * @description:
 */
@Component
public class GoodsItemConverter implements BaseConverter<GoodsItemBO, GoodsItemDO> {

    @Autowired
    @Lazy
    private GoodsService goodsService;

    @Override
    public GoodsItemBO toBO(GoodsItemDO d) {
        GoodsBO goodsBO = goodsService.query(d.getGoodsId());
        return buildBO(d, goodsBO);
    }

    private GoodsItemBO buildBO(GoodsItemDO goodsItemDO, GoodsBO goodsBO) {
        GoodsItemBO goodsItemBO = new GoodsItemBO();
        BeanUtils.copyProperties(goodsItemDO, goodsItemBO);
        goodsItemBO.setGoodsBO(goodsBO);
        return goodsItemBO;
    }

    @Override
    public GoodsItemDO toDO(GoodsItemBO b) {
        GoodsItemDO goodsItemDO = new GoodsItemDO();
        BeanUtils.copyProperties(b, goodsItemDO);
        return goodsItemDO;
    }

    @Override
    public List<GoodsItemBO> toBO(List<GoodsItemDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        Set<Long> goodsIdSet = list.stream().map(x -> x.getGoodsId()).collect(Collectors.toSet());
        QueryGoodsDTO dto = new QueryGoodsDTO();
        dto.setIds(goodsIdSet);
        dto.setSize(goodsIdSet.size());
        PetPage<GoodsBO> query = goodsService.query(dto);
        Map<Long, GoodsBO> goodsBOMap = query.getList().stream().collect(Collectors.toMap(x -> x.getId(), x -> x, (o, n) -> n));
        List<GoodsItemBO> result = new ArrayList<>();
        for (GoodsItemDO goodsItemDO : list) {
            GoodsItemBO goodsItemBO = buildBO(goodsItemDO, goodsBOMap.get(goodsItemDO.getId()));
            result.add(goodsItemBO);
        }
        return result;
    }
}
