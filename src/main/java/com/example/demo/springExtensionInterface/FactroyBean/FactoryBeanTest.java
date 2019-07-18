package com.example.demo.springExtensionInterface.FactroyBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author fulj
 * @date 2019年07月13日 1:02 PM
 */
public class FactoryBeanTest implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new AOP();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanTest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
