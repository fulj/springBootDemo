package com.example.demo.springExtensionInterface.BeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年07月13日 1:38 PM
 */
@Component
public class BeanFactoryPostProcessTest implements BeanFactoryPostProcessor {
    /**
     * 在标准初始化之后修改应该程序上下文工厂。所有的beandefinition已经加载了，但还没有实例化bean。
     * 可以覆盖或者修改属性 比如将Bean的scope从singleton改变为prototype。
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("testBean");
        MutablePropertyValues beanProperty = beanDefinition.getPropertyValues();
        System.err.println("scop before change:" + beanDefinition.getScope());
        beanDefinition.setScope("prototye");
        System.err.println("scop after change:" + beanDefinition.getScope());
        System.err.println("beanProperty:" + beanProperty);
    }
}
