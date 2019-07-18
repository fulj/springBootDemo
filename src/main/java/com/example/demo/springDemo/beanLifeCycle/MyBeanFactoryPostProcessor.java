package com.example.demo.springDemo.beanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor() {
        System.err.println("MyBeanFactoryPostProcessor 构造器实例化");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.err.println("MyBeanFactoryPostProcessor#postProcessBeanFactory()");

        System.err.println("count bean = "+beanFactory.getBeanDefinitionCount());

        System.err.println("beanDefinitionName number is "+ beanFactory.getBeanDefinitionNames().length);
        for(String beanDefinitionName : beanFactory.getBeanDefinitionNames()){
            System.err.println("   "+ beanDefinitionName);
        }

        System.err.println("singletonNames number is "+ beanFactory.getSingletonNames().length);
        for(String singletonName : beanFactory.getSingletonNames()){
            System.err.println("   "+ singletonName);
        }

        BeanDefinition bd = beanFactory.getBeanDefinition("user");
        bd.getPropertyValues().addPropertyValue("id", "110");
    }
}