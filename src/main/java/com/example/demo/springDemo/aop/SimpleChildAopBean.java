package com.example.demo.springDemo.aop;

/**
 * @author skywalker
 */
public class SimpleChildAopBean extends SimpleAopBean {

    @Override
    public void testC() {
        System.out.println("child testC");
    }
}
