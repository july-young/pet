package com.july.pet.config;

import com.july.pet.common.Result;
import com.july.pet.exception.PetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: july
 * @date: 2020/8/1 01:01
 * @description:
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return Result.fail(e.getMessage());
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(PetException.class)
    @ResponseBody
    public Result handleOpdRuntimeException(PetException e) {
        // 不打印异常堆栈信息
        LOG.error(e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }
}
