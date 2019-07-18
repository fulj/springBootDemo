package com.example.demo.springExtensionInterface.InitAndDisposableBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * InitialingBean 在属性设置完毕后做一些自定义操作。 DisposableBean 在关闭容器前做一些操作。
 */
@Component
public class InitDisposableTest implements InitializingBean,DisposableBean {
    @Value("${config.name}")
    public void setName(String name) {
        System.err.println("setName");
        this.name = name;
    }

    private String name;

    @Override
    public void destroy() throws Exception {
        System.err.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("afterProertiesSet");
    }
}
