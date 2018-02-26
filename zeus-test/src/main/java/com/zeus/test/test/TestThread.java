package com.zeus.test.test;

/**
 * @author keven
 * @date 2018-02-25 下午1:36
 * @Description
 */

class Sync {

    public synchronized void test() throws Exception {
        System.out.println("test start ..");
        Thread.sleep(1000);
        System.out.println("test end ..");
    }
}

class MyThread extends Thread {

    private Sync sync;

    public MyThread (Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        try {
            sync.test();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class TestThread {

    public static void main(String[] args) {
        Sync sync = new Sync();
        for (int i=0; i<3; i++) {
            Thread thread = new MyThread(sync);
            thread.start();
        }
    }
}
