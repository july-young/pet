package com.july.pet.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: july
 * @date: 2020/7/31 10:31
 * @description: 服务器响应结果
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    private String msg;

    private T data;

    public Result(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, T data) {
        this.status = code;
        this.data = data;
    }

    public Result() {
    }

    public static Result success() {
        return new Result(PetConstant.SUCCESS_CODE, "OK");
    }

    public static <T> Result<T> success(T data) {
        return new Result(PetConstant.SUCCESS_CODE, data);
    }

    public static Result success(String msg) {
        return new Result(PetConstant.SUCCESS_CODE, msg, null);
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result(PetConstant.SUCCESS_CODE, msg, data);
    }

    public static Result fail() {
        return new Result(PetConstant.FAIL_CODE, "FAIL");
    }

    public static <T> Result<T> fail(T data) {
        return new Result(PetConstant.FAIL_CODE, data);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(PetConstant.FAIL_CODE, msg, null);
    }

    public static <T> Result<T> fail(int status, String msg) {
        return new Result(status, msg, null);
    }


}

