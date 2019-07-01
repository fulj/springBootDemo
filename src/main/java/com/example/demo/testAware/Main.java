package com.example.demo.testAware;

import com.example.demo.configuration.SampleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fulj
 * @date 2019年06月29日 8:19 PM
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SampleConfig.class);
        CustomApplicationAware bean = context.getBean(CustomApplicationAware.class);
        bean.say();
        bean.say2();
    }


}
