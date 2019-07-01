package com.example.demo.proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现JDK动态代理最主要的是下面两个
 * implements InvocationHandler 对代理方法的增强
 * Proxy.newProxyInstance 这个创建一个代理类
 *
 */
public class WangMeiLiProxy implements InvocationHandler {
    private Girl girl;

    public WangMeiLiProxy(Girl girl) {
        super();
        this.girl = girl;
    }

    /**
     * 这里涉及到一些反射的知识
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomeThingBefore();
        Object ret = method.invoke(girl, args);
        doSomeThingAfter();
        return ret;
    }

    private void doSomeThingBefore(){
        System.out.println("王美丽的母亲说：我得先调查下这个男孩子的背景！");
    }

    private void doSomeThingAfter() {
        System.out.println("王美丽的母亲说：他有没有对你动手动脚");
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }
}
