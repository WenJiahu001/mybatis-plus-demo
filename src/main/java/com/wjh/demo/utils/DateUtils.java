package com.wjh.demo.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 文家虎
 * @Package com.wjh.demo.utils
 * @date 2021/6/17 16:43
 */
public class DateUtils {

    /**
     * 指定日期时间退后n天
     *
     * @param date
     * @return
     */
    public static Date addDays(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);
        date = calendar.getTime();
        return date;
    }
}
