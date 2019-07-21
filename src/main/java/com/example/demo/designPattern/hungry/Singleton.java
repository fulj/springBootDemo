package com.example.demo.designPattern.hungry;

/**
 * 饿汉式单例类：在类初始化时，已经自行实例化
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {
    };

    public static Singleton getInstance(){
        return singleton;
    }
}
