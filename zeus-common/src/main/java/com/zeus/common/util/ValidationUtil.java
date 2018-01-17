package com.zeus.common.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author keven
 */
public class ValidationUtil {

    private static Pattern PATTERN_TEL = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    private static Pattern PATTERN_MAIL = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");



    public static void checkNull(Object obj) {

    }


    // 验证手机号
    public static boolean isMobile(String str) {
        Matcher m = PATTERN_TEL.matcher(str);
        return m.matches();
    }

    //验证邮箱
    public static boolean isMail(String str){
        Matcher m = PATTERN_MAIL.matcher(str);
        return m.matches();
    }




}
