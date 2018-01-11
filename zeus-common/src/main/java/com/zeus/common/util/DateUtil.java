package com.zeus.common.util;

import com.google.common.collect.Lists;
import com.zeus.common.exception.ParseException;
import com.zeus.common.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author keven
 * @date 2018-01-10 下午10:01
 * @Description 日期 工具
 */
@Slf4j
public class DateUtil {

    /**
     * 将 long 类型的时间戳 转换成 String 类型的 日期格式
     *
     * @param timeStamp 时间戳
     * @param pattern   日期格式 如 yyyy-MM-dd HH:mm:ss
     * @return String 类型的日期 如 2018-01-10 12:00:00
     */
    public static String formatTimeStampToString(Long timeStamp, String pattern) {
        Date date = new Date(timeStamp * 1000);
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 将 date 类型的日期 转换为 long 类型
     *
     * @param date date 日期格式
     * @return date 对应的时间戳
     */
    public static Long parseDateToLong(Date date) {
        if (date == null) {
            throw new ValidateException("date.is.null");
        }
        return date.getTime() / 1000;
    }

    /**
     * 将 String 类型 的日期 转换为 long 类型
     *
     * @param dateString String 类型的日期
     * @param pattern    日期格式
     * @return long 类型的时间戳
     */
    public static Long parseStringToLong(String dateString, String pattern) {
        if (StringUtils.isEmpty(dateString)) {
            throw new ValidateException("date.string.is.null");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            log.error("fail parse dateString to date");
            throw new ParseException("fail.parse.string.to.date");
        }
        return parseDateToLong(date);
    }


    /**
     * 将 String 类型的 日期格式 转换为 Date 类型
     *
     * @param dateString String 类型日期格式
     * @param pattern    日期格式
     * @return date类型
     */
    public static Date parseStringToDate(String dateString, String pattern) {
        if (dateString == null) {
            throw new ValidateException("date.string.is.null");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            log.error("fail parse String to Date");
        }
        return date;
    }


    /**
     * 将 date 日期格式 转换为 String 类型
     * @param date date
     * @param pattern 日期格式
     * @return String 类型
     */
    public static String formatDateToString(Date date, String pattern) {
        if (date == null) {
            throw new ValidateException("date.is.null");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取 固定间隔 时刻集合
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param interval  间隔 如 5 分钟，30 分钟，60分钟 等
     * @return 时刻集合
     */
    public static List<String> getIntervalTimeList(Date startDate, Date endDate, int interval, String pattern) {
        List<String> dates = Lists.newArrayList();
        while (startDate.before(endDate)) {
            dates.add(formatDateToString(startDate, pattern));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE, interval);

            if (calendar.getTime().after(endDate)) {
                if (!startDate.equals(endDate)) {
                    dates.add(formatDateToString(endDate, pattern));
                }
                startDate = calendar.getTime();
            } else {
                startDate = calendar.getTime();
            }
        }
        return dates;
    }

}
