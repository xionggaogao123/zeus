package com.zeus.test.data;


import com.zeus.common.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {


    /**
     * 获取固定间隔时刻集合
     * @param start 开始时间
     * @param end 结束时间
     * @param interval 时间间隔(单位：分钟)
     * @return
     */
    public static List<String> getIntervalTimeList(String start, String end, int interval){
        Date startDate = new Date(1515373209000L);
        Date endDate = new Date(1515478480000L);
        List<String> list = new ArrayList<>();
        while(startDate.getTime()<=endDate.getTime()){
            list.add(DateUtils.format(startDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE,interval);
            if(calendar.getTime().getTime()>endDate.getTime()){
                if(!startDate.equals(endDate)){
                    list.add(DateUtils.format(endDate));
                }
                startDate = calendar.getTime();
            }else{
                startDate = calendar.getTime();
            }
        }
        return list;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }



    public static void main(String[] args) {

           /* Long a = 1515489240L;
            Long b = 1515489180L;
            Long c = a - b;
            System.out.println(c);*/

      List<String> strings = getIntervalTimeList(null, null, 5);
       System.out.println("strings :" + strings);
       strings.forEach(DateUtils::stringToInteger);
       System.out.println("ss" + strings);

            //String ss = stampToDate("1515489240");
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ss = simpleDateFormat.format(new Date(1515489180L));
            System.out.println(ss);*/

      /*  String ss = getDateStringByTimeSTamp(a, "yyyy-MM-dd HH:mm:ss");
        System.out.println(ss);*/

      /*  List<String> ss = getIntervalTimeList("1514971410", "1515577210", 60);
        System.out.println("ss.size()" + ss.size());*/



    }
}
