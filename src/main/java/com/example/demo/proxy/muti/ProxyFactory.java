package com.example.demo.proxy.muti;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory {
    private ProxyFactory() {}
    public static ProxyFactory create() {
        return new ProxyFactory();
    }
    public Object getProxy(Object origin) {
        final Enhancer en = new Enhancer();
        en.setSuperclass(origin.getClass());
        List<Chain.Point> list = new ArrayList<>();
        list.add(new Point1());
        list.add(new Point2());
        en.setCallback(new Interceptor(new Chain(list, origin)));
        return en.create();
    }
    private class Interceptor
            implements MethodInterceptor {
        Chain chain;
        public Interceptor(Chain chain) {
            this.chain = chain;
        }
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                throws Throwable {
            return chain.proceed();
        }
    }
}