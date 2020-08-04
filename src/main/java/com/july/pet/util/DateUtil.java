package com.july.pet.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: july
 * @date: 2020/8/4 10:24
 * @description:
 */
public class DateUtil {


    public static int gapDay(Date start, Date end) {
        Calendar calStart = zeroOfDay(start);
        Calendar calEnd = zeroOfDay(end);

        long gap = calEnd.getTime().getTime() - calStart.getTime().getTime();
        return (int) (gap / 24 * 3600 * 1000);
    }

    public static Calendar zeroOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar;
    }

}
