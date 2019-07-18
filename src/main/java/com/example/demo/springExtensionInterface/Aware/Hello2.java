package com.example.demo.springExtensionInterface.Aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年07月13日 1:23 PM
 */
@Component
public class Hello2 implements BeanNameAware,BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        beanFactory.getBean(Hello2.class).setBeanName("hello2 change");
        System.out.println("getBeanFactory:"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("getBeanname:"+name);
    }
}
