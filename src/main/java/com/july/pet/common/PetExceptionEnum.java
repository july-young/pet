package com.july.pet.common;

/**
 * @author: july
 * @date: 2020/7/31 14:45
 * @description:
 */
public enum PetExceptionEnum implements BaseEnum {

    DB_INSERT_ERROR(10001, "插入数据失败！"),
    DB_UPDATE_ERROR(10002, "更新数据失败，或数据不存在！"),
    DATA_NOT_EXISTS(10003, "该条数据不存在！"),
    DATA_NOT_BE_NULL(10004, "该条数据不能为空！"),;
    /**
     * 错误代码
     */
    private Integer code;

    /***
     * 错误信息
     */
    private String message;

    PetExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
