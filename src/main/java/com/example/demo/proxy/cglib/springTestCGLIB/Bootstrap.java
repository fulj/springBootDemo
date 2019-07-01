package com.example.demo.proxy.cglib.springTestCGLIB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fulj
 * @date 2019年06月30日 6:46 PM
 */
public class Bootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Config config = context.getBean(Config.class);
    }
}
