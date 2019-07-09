package com.example.demo.springDemo.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author fulj
 * @date 2019年07月09日 10:45 AM
 */
@Component
public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("===Hello, I'm a Listener==≠≠≠");
    }
}
