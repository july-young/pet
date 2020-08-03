package com.july.pet.entity;

import com.july.pet.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GoodsItemDO extends BaseDO {

    private Long goodsId;

    private Date gmtOpen;

    private Date gmtLastOpen;

    private Date gmtExpire;

    private Date gmtBuy;

    private String channel;

    private Long userId;

    private Integer price;

    private Long recordId;

}