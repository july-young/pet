package com.july.pet.form;

import com.july.pet.bo.UserBO;
import com.july.pet.common.AbstractForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @author: july
 * @date: 2020/7/31 10:45
 * @description:
 */
@Getter
@Setter
public class CreateUserForm extends AbstractForm<UserBO> {

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 微信号
     */
    @ApiModelProperty("微信号")
    private String wxNum;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    @Override
    public UserBO toBO() {
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(this, userBO);
        return userBO;
    }
}
