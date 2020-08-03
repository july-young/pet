package com.july.pet.dto;

import com.july.pet.common.BaseQueryPageDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author: july
 * @date: 2020/8/3 09:19
 * @description:
 */
@Getter
@Setter
public class QueryGoodsDTO extends BaseQueryPageDTO {

    public Collection<Long> ids;

}
