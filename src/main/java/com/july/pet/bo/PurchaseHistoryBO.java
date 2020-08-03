package com.july.pet.bo;

import com.july.pet.common.BaseBO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 14:42
 * @description:
 */
@Getter
@Setter
public class PurchaseHistoryBO extends BaseBO {

    private Integer price;

    private Integer amount;

    private String channel;

    private Date gmtExpire;

    private Date gmtBuy;

    private Long userId;

    private Long goodsId;

    private GoodsBO goodsBO;

    private List<String> imgUrls;
}
