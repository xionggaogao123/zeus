package com.zeus.test.util;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author keven
 * @date 2018-01-15 上午11:19
 * @Description
 */
public class TestMain {

    private static String generateActivationCode() {
        DecimalFormat df = new java.text.DecimalFormat("000000");
        Random r2 = new Random();
        return df.format(r2.nextInt(1000000));
    }

    public static void main(String[] args) {
        String code = generateActivationCode();
        System.out.println("code={}" + code);
    }
}
