package com.example.demo.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class App666ApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("+++++++++++++++++++++++++++++++++++++++++++++");
        if (event instanceof ContextStartedEvent){
            log.info("================:{}", "ContextStartedEvent");
        }
        if (event instanceof ContextRefreshedEvent){
            log.info("================:{}", "ContextRefreshedEvent");
        }
        if (event instanceof ContextClosedEvent){
            log.info("================:{}", "ContextClosedEvent");
        }
        if (event instanceof ContextStoppedEvent){
            log.info("================:{}", "ContextStoppedEvent");
        }
//        if (event instanceof EmbeddedServletContainerInitializedEvent){
//            log.info("================:{}", "EmbeddedServletContainerInitializedEvent");
//        }
        if (event instanceof ApplicationReadyEvent){
            log.info("================:{}", "ApplicationReadyEvent");
        }
        log.info(">>>>>>>>>>>>>>>>:{}\n", event.getClass().getName());
    }

}