package com.example.demo.springExtensionInterface.BeanFactoryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fulj
 * @date 2019年07月13日 1:47 PM
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.example.demo.springExtensionInterface.BeanFactoryPostProcessor");
    }
}
