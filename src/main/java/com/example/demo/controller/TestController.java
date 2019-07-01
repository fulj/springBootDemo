package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fulj
 * @program: springBootDemo
 * @create: 2018-07-10 14:35
 **/
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/testCacheable")
    public String testCacheable() {
        testService.testCacheable("123");
        return "Hello SpringBoot! I'm serverB";
    }
    @RequestMapping("/testCachePut")
    public String testCachePut() {
        testService.testCachePut("123");
        return "Hello SpringBoot! I'm serverB";
    }
    /**
     * 第一个要搞清楚缓存的时间在哪里
     * 第二个要搞清楚缓存的key是什么
     */
}
