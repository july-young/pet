package com.july.pet.exception;


import com.july.pet.common.BaseEnum;
import com.july.pet.common.PetExceptionEnum;
import lombok.Getter;
import lombok.Setter;


/**
 * @author: july
 * @date: 2020/7/31 14:43
 * @description:
 */
@Getter
@Setter
public class PetException extends RuntimeException {

    private Integer code;

    public PetException(PetExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
