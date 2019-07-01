package com.example.demo.proxy.cglib.springTestCGLIB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author fulj
 * @date 2019年06月30日 6:44 PM
 */
@Configuration//加上这个注解spring就会用CGLIB代理 保证单例
@ComponentScan("com.example.demo.proxy.cglib.springTestCGLIB")
public class Config {

    @Bean
    public OrderDao orderDao(){
        productDao();
        return new OrderDao();
    }

    @Bean
    public ProductDao productDao(){
        return new ProductDao();
    }
}
