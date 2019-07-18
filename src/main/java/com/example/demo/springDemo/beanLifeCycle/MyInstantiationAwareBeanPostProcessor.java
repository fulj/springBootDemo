package com.example.demo.springDemo.beanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        System.err.println("MyInstantiationAwareBeanPostProcessor构造器");
    }

    // 实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.err.println("bean实例化之前调用，InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation");
        return null;
    }
    // 实例化Bean之后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.err.println("bean实例化之后前调用，InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation");
        return false;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName) throws BeansException {
        System.err.println("接口方法、设置某个属性时调用，InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法 ");
        return pvs;
    }
}
