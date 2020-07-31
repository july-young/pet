package com.july.pet.bo;

import com.july.pet.common.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: july
 * @date: 2020/7/31 10:46
 * @description:
 */
@Getter
@Setter
@ApiModel("用户BO")
public class UserBO extends BaseBO {

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("微信号")
    private String wxNum;

    @ApiModelProperty("手机号")
    private String phone;

}