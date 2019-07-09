package com.example.demo.ThreadPoolDemo;

import java.util.concurrent.*;

public class CreateThreadPool {
    public static void main(String args[]) {
        //不建议的做法
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //使用 guava 开源框架的 ThreadFactoryBuilder 给线程池的线程设置名字
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(4, 10, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(256),
//                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();
    }
}
