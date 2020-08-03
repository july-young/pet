package com.july.pet.form;

import com.july.pet.bo.GoodsBO;
import com.july.pet.bo.PurchaseHistoryBO;
import com.july.pet.common.AbstractForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/8/3 15:53
 * @description:
 */
@Getter
@Setter
@ApiModel("创建购买记录表单")
public class CreatePurchaseHistoryForm extends AbstractForm<PurchaseHistoryBO> {

    @Max(value = 100000, message = "最大价格为1000元")
    @Min(value = 0, message = "最低价格为0元")
    @ApiModelProperty("价格（分）")
    private Integer price;

    @Max(value = 1000, message = "最大数量为1000")
    @Min(value = 0, message = "最小数量为0元")
    @ApiModelProperty("数量")
    private Integer amount;

    @NotNull(message = "渠道不能为空")
    @ApiModelProperty("渠道")
    private String channel;


    @ApiModelProperty("过期时间")
    @NotNull(message = "过期时间不能为空")
    private Date gmtExpire;

    @NotNull(message = "购买时间不能为空")
    @ApiModelProperty("购买时间")
    private Date gmtBuy;

//    @NotNull(message = "商品ID不能为空")
//    @ApiModelProperty("商品ID")
    private Long goodsId;

    @NotNull(message = "图片地址不能为空！")
    @ApiModelProperty("图片地址")
    private List<String> imgUrls;

    @NotNull(message = "商品不能为空")
    @ApiModelProperty("商品")
    private GoodsBO goodsBO;

    @Override
    public PurchaseHistoryBO toBO() {
        PurchaseHistoryBO purchaseHistoryBO = new PurchaseHistoryBO();
        BeanUtils.copyProperties(this, purchaseHistoryBO);
        return purchaseHistoryBO;
    }
}
