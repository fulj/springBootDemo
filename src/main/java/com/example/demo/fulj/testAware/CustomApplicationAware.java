package com.example.demo.fulj.testAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年06月29日 7:50 PM
 */
@Component("customApplicationAware")
public class CustomApplicationAware implements ApplicationContextAware,BeanFactoryAware {
    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void say(){
        User user = (User) applicationContext.getBean("user");
        user.say();
    }
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void say2(){
        User user = (User) beanFactory.getBean("user");
        System.out.println("from beanFactory");
        user.say();
    }
}
