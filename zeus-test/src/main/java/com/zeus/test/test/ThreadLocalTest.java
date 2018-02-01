package com.zeus.test.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author keven
 * @date 2018-01-29 下午2:05
 * @Description threadLocal 测试
 */
public class ThreadLocalTest {

    private static final AtomicInteger nextId = new AtomicInteger(0);


    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static int get() {
        return threadId.get();
    }

    public void test() {


    }

    public static void main(String[] args){




    }

}
