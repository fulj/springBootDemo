package com.example.demo.ThreadPoolDemo.CountDownDemo;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author fulj
 * @date 2019年07月08日 9:35 PM
 */
public class WorkerCount extends Thread {
    private String name;
    private long time;
    private CountDownLatch countDownLatch;


    public WorkerCount(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "工作完成，耗时" + time);
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount()" + countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
