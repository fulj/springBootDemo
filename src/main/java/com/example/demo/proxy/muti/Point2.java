package com.example.demo.proxy.muti;

public class Point2 implements Chain.Point {

    @Override
    public Object proceed(Chain chain) throws InterruptedException {
        System.out.println("point 2 before");
        Thread.sleep(20);
        Object result = chain.proceed();
        Thread.sleep(20);
        System.out.println("point 2 after");
        return result;
    }
}