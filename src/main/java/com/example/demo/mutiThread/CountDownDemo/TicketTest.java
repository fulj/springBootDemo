package com.example.demo.mutiThread.CountDownDemo;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fulj
 * @date 2019年07月08日 5:27 PM
 */
public class TicketTest {
    private static int count = 100;

    private Lock lock = new ReentrantLock();

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    @Test
    public void tickTest() throws InterruptedException {
        TicketRunnale tr = new TicketRunnale();
        // 四个线程对应四个窗口
        Thread t1 = new Thread(tr, "窗口A");
        Thread t2 = new Thread(tr, "窗口B");
        Thread t3 = new Thread(tr, "窗口C");
        Thread t4 = new Thread(tr, "窗口D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        countDownLatch.await();
//        Thread.currentThread().join();
    }

    public class TicketRunnale implements Runnable {

        @Override
        public void run() {
            while (count > 0) {
                lock.lock();
                try {
                    if (count > 0) {
                        System.out.println(Thread.currentThread().getName()+"售出"+(count--)+"张票");
                        countDownLatch.countDown();
                    }
                } catch (Exception e) {

                }finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
