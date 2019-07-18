package com.example.demo.springExtensionInterface.Aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年07月13日 1:25 PM
 */
@Component
public class Hello3 implements BeanNameAware,BeanFactoryAware,ApplicationContextAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("getBeanFactory:"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("getBeanname:"+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHold.applicationContext = applicationContext;
        this.applicationContext = applicationContext;
        applicationContext.getBean(Hello3.class).setBeanName("change");
        System.out.println("getApplicationContext:"+applicationContext);
    }
}
