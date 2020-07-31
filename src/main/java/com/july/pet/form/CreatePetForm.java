package com.july.pet.form;

import com.july.pet.bo.PetBO;
import com.july.pet.common.AbstractForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author: july
 * @date: 2020/7/31 23:53
 * @description:
 */
@Getter
@Setter
@ApiModel("宠物创建表单")
public class CreatePetForm extends AbstractForm<PetBO> {

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("品种")
    private String brand;

    @ApiModelProperty("性别")
    private Boolean gender;

    @ApiModelProperty("生育数")
    private Integer children;

    @ApiModelProperty("疫苗状态")
    private Integer vaccine;

    @ApiModelProperty("驱虫")
    private Boolean repellent;

    @ApiModelProperty("是否绝育")
    private Boolean sterilization;

    @ApiModelProperty("是否生育")
    private Boolean bear;

    @ApiModelProperty("图片地址集合")
    private List<String> imgUrlList;

    @Override
    public PetBO toBO() {
        PetBO petBO = new PetBO();
        BeanUtils.copyProperties(this,petBO);
        return petBO;
    }
}
