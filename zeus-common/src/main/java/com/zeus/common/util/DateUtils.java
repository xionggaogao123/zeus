package com.zeus.common.util;

import com.google.common.collect.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by elfxwt on 15/12/3.
 */
public class DateUtils {

    public final static String SYSTEM_MAX_DATE = "2600-12-30 23:59:59";

    public static Long parse2Long(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime() / 1000;
    }

    /**
     * yyyy-mm-dd HH:mm:ss string to long
     *
     * @param dateString
     * @return
     */

    public static Long string2Long(String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse2Long(date);
    }

    /**
     * string to date
     *
     * @param dateString
     * @return
     */

    public static Date string2Date(String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * string to date
     *
     * @param dateString
     * @return
     */

    public static Date string2DateB(String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * string to date
     *
     * @param dateString
     * @return
     */

    public static Date string2DateWithHHmm(String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * string to date
     *
     * @param dateString
     * @return
     */

    public static Date string2DateWithHHmmss(String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatByPattern(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static String format2MMDDHH(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    public static String format2HHMM(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    /**
     * Date to yyyy-mm-dd HH:mm:ss
     *
     * @param date
     * @return
     */

    public static String format(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    public static String formatB(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

    public static String formatC(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    public static String formatD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    public static String formatE(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    public static String formatF(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-HH");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }

    public static String formatG(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        return dateString;

    }


    /**
     * add one day for current day
     *
     * @param date
     * @return
     */
    public static Date addOneDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        date = cal.getTime();
        return date;


    }

    /**
     * add one hour for current day
     *
     * @param date
     * @return
     */
    public static Date addOneHour(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 1);
        date = cal.getTime();
        return date;


    }

    /**
     * 获取日期对应的年份
     *
     * @param date 日期
     * @return 年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取日期对应的月份（从1开始）
     *
     * @param date 日期
     * @return 月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 将date转化成整数 yyyyMMdd
     *
     * @param data
     * @return
     */
    public static Integer dateToInteger(Date data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat statTimeDateFormat = new SimpleDateFormat("yyyyMMdd");
        Integer time = Integer.valueOf(statTimeDateFormat.format(data));
        return time;
    }

    public static Integer dateToIntegerWithFormat(Date data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat statTimeDateFormat = new SimpleDateFormat("yyyyMMdd");
        Integer time = Integer.valueOf(statTimeDateFormat.format(data));
        return time;
    }

    /**
     * 将yyyyMMdd,yyyy-MM-dd格式的字符串转为yyyyMMdd的整数
     *
     * @param data
     * @return
     */
    public static Integer stringToInteger(String data) {
        if (data == null) {
            return null;
        }
        if (data.length() == 8) {
            return Integer.valueOf(data);
        } else if (data.length() == 10) {
            try {
                String[] calendarStr = data.split("-");
                return Integer.valueOf(calendarStr[0] + calendarStr[1] + calendarStr[2]);
            } catch (Exception e) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 将整数yyyyMMdd转化成date
     *
     * @param data
     * @return
     */
    public static Date integerToDate(Integer data) {
        if (data == null) {
            return null;
        }
        return string2DateB(data.toString());
    }

    /**
     * 比较两个日期之间相差的天数
     *
     * @param begin
     * @param end
     * @return
     */

    public static Long getcompareDays(Date begin, Date end) {
        Long days = 0L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String oldDay = simpleDateFormat.format(begin);
        String newDay = simpleDateFormat.format(end);

        try {
            Date beginDate = simpleDateFormat.parse(oldDay);
            Date endDate = simpleDateFormat.parse(newDay);
            return (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
//            logger.error("[getCompareDays] exception",e);
        }

        return days;

    }


    /**
     * @param ss 要转换的秒数
     * @return 该秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author fy.zhang
     */
    public static String formatDuringSS(long ss) {
        if (ss <= 0) {
            return "";
        }
        long days = ss / (60 * 60 * 24);
        long hours = (ss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (ss % (60 * 60)) / (60);
        long seconds = (ss % 60);
        StringBuffer context = new StringBuffer();
        if (days > 0) {
            context.append(days);
            context.append("天");
        }
        if (hours > 0) {
            context.append(hours);
            context.append("小时");
        }
        if (minutes > 0) {
            context.append(minutes);
            context.append("分钟");
        }
        if (seconds > 0) {
            context.append(seconds);
            context.append("秒");
        }
        return context.toString();
    }

    /**
     * 取该月第一天0点
     */
    public static Date getFirstDayOfMonth(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天的开始时间
     *
     * @return
     */
    public static Date getCurDayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天的开始时间
     * 返回yyyy-MM-dd HH:mm:ss的String类型
     *
     * @return
     */
    public static String getCurDayStartTimeString() {
        Date date = getCurDayStartTime();
        return DateUtils.format(date);
    }

    /**
     * 获取当天的结束时间
     *
     * @return
     */
    public static Date getCurDayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }


    /**
     * 获取一个今日的整点时间
     *
     * @return
     */
    public static Date getCurDayTime(Integer hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取该天的开始时间
     *
     * @return
     */
    public static Date getDayStartTime(Date date) {
        Calendar dayStart = Calendar.getInstance();
        dayStart.setTime(date);
        dayStart.set(Calendar.HOUR_OF_DAY, 0);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);
        return dayStart.getTime();
    }

    /**
     * 获取该天的结束时间
     *
     * @return
     */
    public static Date getDayEndTime(Date date) {
        Calendar dayEnd = Calendar.getInstance();
        dayEnd.setTime(date);
        dayEnd.set(Calendar.HOUR_OF_DAY, 23);
        dayEnd.set(Calendar.MINUTE, 59);
        dayEnd.set(Calendar.SECOND, 59);
        dayEnd.set(Calendar.MILLISECOND, 0);
        return dayEnd.getTime();
    }

    /**
     * 获取当前时间 上一天的开始时间
     *
     * @param date
     * @return
     */
    public static Date getYesterdayStartTime(Date date) {

        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.add(Calendar.DATE, -1);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);

        return todayStart.getTime();
    }

    public static Date getYesterdayStartTime() {
        return getYesterdayStartTime(new Date());
    }

    /**
     * 获取昨天开始时间
     *
     * @return
     */
    public static String getYesterdayStartTimeString() {
        Date yesterdayStartTime = getYesterdayStartTime();
        return format(yesterdayStartTime);
    }

    public static Date getYesterdayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.DATE, -1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }

    /**
     * 获取当前时间 上一天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getYesterdayEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.add(Calendar.DATE, -1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }

    /**
     * 获取当前时间 上一天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getYesterday(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.add(Calendar.DATE, -1);
        return todayEnd.getTime();
    }

    /**
     * 日期加减
     *
     * @param date
     * @return
     */
    public static Date getDayAdd(Date date, Integer day) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.add(Calendar.DATE, day);
        return todayEnd.getTime();
    }

    /**
     * 小时加减
     *
     * @param date
     * @return
     */
    public static Date getHourAdd(Date date, Integer hour) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.add(Calendar.HOUR_OF_DAY, hour);
        return todayEnd.getTime();
    }

    /**
     * 获取当前时间 小时的开始时间
     *
     * @param date
     * @return
     */
    public static Date getHourBeginTime(Date date) {
        Calendar hourStart = Calendar.getInstance();
        hourStart.setTime(date);
        hourStart.set(Calendar.MINUTE, 0);
        hourStart.set(Calendar.SECOND, 0);
        hourStart.set(Calendar.MILLISECOND, 0);
        return hourStart.getTime();
    }

    /**
     * 获取当前时间 上一个小时的开始时间
     *
     * @param date
     * @return
     */
    public static Date getPreHourBeginTime(Date date) {
        Calendar hourStart = Calendar.getInstance();
        hourStart.setTime(date);
        hourStart.add(Calendar.HOUR, -1);
        hourStart.set(Calendar.MINUTE, 0);
        hourStart.set(Calendar.SECOND, 0);
        hourStart.set(Calendar.MILLISECOND, 0);
        return hourStart.getTime();
    }

    /**
     * 获取当前时间 下一个小时的开始时间
     *
     * @param date
     * @return
     */
    public static Date getNextHourBeginTime(Date date) {
        Calendar hourStart = Calendar.getInstance();
        hourStart.setTime(date);
        hourStart.add(Calendar.HOUR_OF_DAY, 1);
        hourStart.set(Calendar.MINUTE, 0);
        hourStart.set(Calendar.SECOND, 0);
        hourStart.set(Calendar.MILLISECOND, 0);
        return hourStart.getTime();
    }

    /**
     * 获取当前时间 下一个小时的开始时间
     *
     * @param date
     * @return
     */
    public static String getNextHourBeginTimeString(Date date) {
        Date nextHourBeginTime = getNextHourBeginTime(date);
        return DateUtils.format(nextHourBeginTime);
    }


    /**
     * 获取今日的剩余秒数
     *
     * @return
     */
    public static Long getRemainSecToday() {
        Date now = new Date();
        Date curDayEndTime = getCurDayEndTime();
        Long mins = curDayEndTime.getTime() - now.getTime();
        if (mins > 0) {
            return mins / 1000L;
        }
        return 0L;
    }

    /**
     * 获取当前小时
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     *
     * @param date
     * @param anotherDate
     * @return
     */
    public static boolean isSameDay(Date date,Date anotherDate) {
        return formatB(date).equals(formatB(anotherDate));
    }

    /**
     * start和end之间的日期，包含start和end
     * 例如：
     * start:2017/03/02 12:00:00
     * end :2017/03/04 13:00:00
     * 返回的list为03/02、03/03、03/04
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> getBetweenDayList(Date start, Date end, String pattern) {
        if (start.after(end)) return Lists.newArrayList();

        List<String> returnBetweentDaysList = Lists.newArrayList();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        returnBetweentDaysList.add(simpleDateFormat.format(start));

        while (true) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.getTime().compareTo(end) == -1 || calendar.getTime().compareTo(end) == 0) {
                returnBetweentDaysList.add(simpleDateFormat.format(calendar.getTime()));
            } else {
                break;
            }
        }

        return returnBetweentDaysList;
    }

    /**
     * string to date
     *
     * @param dateString
     * @return
     */

    public static Date string2DateByPattrn(String pattern, String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getTimeBeforMinute(Integer minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /***
     * 将 day:20171010 hour:10 组合成日期
     * @return
     */
    public static Date IntegerDay2Date(Integer day,Integer hour){
        if (day == null || hour == null){
            return null;
        }
        String dateString = day+""+hour;
        Date date = string2DateByPattrn("yyyyMMddHH", dateString);
        return date;
    }


    public static String getDateStringByTimeSTamp(Long timeStamp,String pattern){
        String result = null;
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        result = sd.format(date);
        return result;
    }

}
