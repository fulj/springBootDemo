package com.example.demo.springExtensionInterface.BeanPostProcess;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RountingInjected {
    String value() default "helloServiceImpl1";
}
