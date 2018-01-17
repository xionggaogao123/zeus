package com.zeus.common.util;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author keven
 * @date 2018-01-15 上午11:28
 * @Description
 */
public class CodeUtil {

    /**
     * 生成6位数 的验证码
     * @return 动态的验证码
     */
    private static String generateActivationCode() {
        DecimalFormat format = new java.text.DecimalFormat("000000");
        Random random = new Random();
        return format.format(random.nextInt(1000000));
    }
}
