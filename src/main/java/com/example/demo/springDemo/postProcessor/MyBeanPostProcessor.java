package com.example.demo.springDemo.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年06月29日 6:14 PM
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
 
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString());
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
        return bean;
    }
}
