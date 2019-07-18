package com.example.demo.springDemo.beanLifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年07月13日 3:19 PM
 */
@Component
public class BeanLifeCycleTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.example.demo.springDemo.beanLifeCycle");
        applicationContext.getBean("user");
        applicationContext.registerShutdownHook();
    }
}
