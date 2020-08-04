package com.july.pet.entity;

import com.july.pet.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PurchaseHistoryDO extends BaseDO {

    private Integer price;

    private Integer amount;

    private String channel;

    private Date gmtExpire;

    private Date gmtBuy;

    private Long userId;

    private Long goodsId;

    private Date gmtOpen;

    private Integer leftDays;

}