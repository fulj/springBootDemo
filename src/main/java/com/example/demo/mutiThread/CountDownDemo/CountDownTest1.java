package com.example.demo.mutiThread.CountDownDemo;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author fulj
 * @date 2019年07月08日 9:38 PM
 */
public class CountDownTest1 {
    @Test
    public void countDownTest() throws InterruptedException {
        int COUNT = 2;
        final CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        WorkerCount worker0 = new WorkerCount("lilei-0", (long)(Math.random() * 10000), countDownLatch);
        WorkerCount worker1 = new WorkerCount("lilei-1", (long)(Math.random() * 10000), countDownLatch);
        worker0.start();
        worker1.start();
        countDownLatch.await();
        System.out.println("准备工作就绪");
        WorkerCount worker2 = new WorkerCount("lilei-2", (long)(Math.random() * 10000), countDownLatch);
        worker2.start();
        Thread.sleep(10000);

    }
}
