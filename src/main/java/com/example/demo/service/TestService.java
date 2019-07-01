package com.example.demo.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author fulj
 * @date 2019年01月06日 4:44 PM
 */
@Service
public class TestService {
    @Cacheable(value = "test",key = "#key")
    public void testCacheable(String key){
        System.out.println("execute testCacheable");
    }
    @CachePut(value = "test1",key = "#key")
    public void testCachePut(String key){
        System.out.println("execute testCachePut");
    }
}
