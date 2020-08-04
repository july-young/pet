package com.july.pet.bo;

import com.july.pet.common.BaseBO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: july
 * @date: 2020/8/3 12:33
 * @description:
 */
@Getter
@Setter
public class GoodsItemBO extends BaseBO {

    private Long goodsId;

    private GoodsBO goodsBO;

    private Date gmtOpen;

    private Date gmtLastOpen;

    private Date gmtExpire;

    private Date gmtBuy;

    private String channel;

    private Long userId;

    private Integer price;

    private Long historyId;

    private String category;
}
