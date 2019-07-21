package com.example.demo.designPattern.lazy;

/**
 * @author fulj
 * @date 2019年07月18日 5:56 PM
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){

    }

    /**
     * 此方式在单线程的时候工作正常，但在多线程的情况下就有问题了。
     * 如果两个线程同时运行到判断instance是否为null的if语句，
     * 并且instance的确没有被创建时，那么两个线程都会创建一个实例，此时类型Singleton1就不再满足单例模式的要求了。
     * @return
     */
    public static Singleton getInstanceA(){
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 为了保证在多线程环境下我们还是只能得到该类的一个实例，只需要在getInstanceB()方法加上同步关键字sychronized，
     * 就可以了。但每次调用getInstanceB()方法时都被synchronized关键字锁住了，会引起线程阻塞，影响程序的性能。
     * @return
     */
    public static synchronized Singleton getInstanceB() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 为了在多线程环境下，不影响程序的性能，不让线程每次调用getInstanceC()方法时都加锁，
     * 而只是在实例未被创建时再加锁，在加锁处理里面还需要判断一次实例是否已存在。
     * @return
     */
    public static Singleton getInstanceC(){
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
