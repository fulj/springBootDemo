package com.example.demo.proxy.muti;

import java.util.List;

public class Chain {
    private List<Point> list;
    private int index = -1;
    private Object target;

    public Chain(List<Point> list, Object target) {
        this.list = list;
        this.target = target;
    }

    public Object proceed() throws InterruptedException {
        Object result;
        if (++index == list.size()) {
            result = (((Test.SayHello)target).toString1());
            System.err.println("Target Method invoke result : " + result);
        } else {
            Point point = list.get(index);
            //实现的关键地方，把this传进去相当于递归，上面的++index == list.size() 为递归返回条件
            //所以递归还能这么用呢。。。
            result = point.proceed(this);
        }
        return result;
    }
    interface Point {
        Object proceed(Chain chain) throws InterruptedException;
    }
}