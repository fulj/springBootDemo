package com.example.demo.fulj.testAware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP测试启动类.
 *
 * @author skywalker
 */
public class Bootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        CustomApplicationAware customApplicationAware = (CustomApplicationAware) context.getBean("customApplicationAware");
        customApplicationAware.say();
        customApplicationAware.say2();
    }




}
