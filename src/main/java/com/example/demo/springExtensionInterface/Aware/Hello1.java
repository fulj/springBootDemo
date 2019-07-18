package com.example.demo.springExtensionInterface.Aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年07月13日 1:22 PM
 */
@Component
public class Hello1 implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("getBeanname:"+name);
    }
}
