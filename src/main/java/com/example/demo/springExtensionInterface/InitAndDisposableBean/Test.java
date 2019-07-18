package com.example.demo.springExtensionInterface.InitAndDisposableBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fulj
 * @date 2019年07月13日 1:26 PM
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.example.demo.springExtensionInterface.InitAndDisposableBean");
        applicationContext.close();
    }
}
