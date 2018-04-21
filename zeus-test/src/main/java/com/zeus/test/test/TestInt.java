package com.zeus.test.test;

import org.junit.Test;

/**
 * @author keven
 * @date 2018-03-29 下午11:12
 * @Description
 */
public class TestInt {

    public Integer age;

    private Integer num;


    public void test01() {

    }

    private void test02() {

    }

    public static void main(String []args) {
        int a = 2^15 -1;

        System.out.println("a : " + a);


        TestInt testInt = new TestInt();
        testInt.test01();
        testInt.test02();
    }


    // Integer 里面有一个cache , 缓存了从 -128 到 127 之间的数值。

    @Test
    public void testIntegerCache() {

        int a = 127;
        int b = 127;;

        System.out.println(a == b); // true


        int a1 = 128;
        int b1 = 128;

        System.out.println(a1 == b1);  // true


        Integer a2 = 127;
        Integer b2 = 127;

        System.out.println(a2 == b2);  // true


        Integer a3 = 128;
        Integer b3 = 128;

        System.out.println(a3 == b3);  // false

    }



}
