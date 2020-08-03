package com.july.pet.util;

/**
 * @author: july
 * @date: 2020/8/3 15:12
 * @description:
 */
public class UserInfoUtil {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    private UserInfoUtil() {

    }

    public static Long getUserId() {
        //todo 完善用户系统
        return 1L;
    }


}
