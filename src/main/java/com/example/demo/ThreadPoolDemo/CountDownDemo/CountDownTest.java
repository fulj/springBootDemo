package com.example.demo.ThreadPoolDemo.CountDownDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author fulj
 * @date 2019年07月08日 10:04 PM
 */
public class CountDownTest {
    static CountDownLatch c = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }
}
