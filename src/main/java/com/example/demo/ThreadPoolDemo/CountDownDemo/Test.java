package com.example.demo.ThreadPoolDemo.CountDownDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author fulj
 * @date 2019年07月08日 10:15 PM
 */
public class Test {
    static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {

        countDownLatch.await();
    }
}
