package com.example.demo.springDemo.beanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

@Component
public class User implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String id;
    private String name;

    private BeanFactory beanFactory;
    private String beanName;

    public User() {
        System.err.println("User 构造器实例化");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.err.println("注入属性 id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.err.println("注入属性 name");
        this.name = name;
    }

    // BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("【BeanFactoryAware接口】 接口调用 BeanFactoryAware.setBeanFactory(BeanFactory beanFactory)");
        this.beanFactory = beanFactory;
    }

    // BeanNameAware
    @Override
    public void setBeanName(String name) {
        System.err.println("【BeanNameAware接口】 接口调用 BeanNameAware.setBeanName(String name)");
        this.beanName = name;
    }

    public void myInit() {
        System.err.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestory() {
        System.err.println("【destroy-method】调用<bean>的destroy-method 属性指定的初始化方法");
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }
}
