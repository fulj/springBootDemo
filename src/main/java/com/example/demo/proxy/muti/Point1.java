package com.example.demo.proxy.muti;
public class Point1 implements Chain.Point {

    @Override
    public Object proceed(Chain chain) throws InterruptedException {
        System.out.println("point 1 before");
        Thread.sleep(20);
        Object result = chain.proceed();
        Thread.sleep(20);
        System.out.println("point 1 after");
        return result;
    }
}