package com.july.pet.form;

import com.july.pet.bo.UserBO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * @author: july
 * @date: 2020/7/31 16:26
 * @description:
 */
@Getter
@Setter
public class UpdateUserForm extends CreateUserForm {

    /**
     * id
     */
    @NotNull(message = "id不能为空！")
    @ApiModelProperty("id")
    private Long id;

    @Override
    public UserBO toBO() {
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(this, userBO);
        return userBO;
    }
}
