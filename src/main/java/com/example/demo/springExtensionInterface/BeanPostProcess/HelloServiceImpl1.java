package com.example.demo.springExtensionInterface.BeanPostProcess;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl1 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl1");
    }
}