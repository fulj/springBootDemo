package com.example.demo.springDemo.aop;

import org.springframework.aop.framework.AopContext;

/**
 * @author skywalker
 */
public class SimpleAopBean {

    private String remark = "备注";

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void boo() {
        System.out.println("testA执行");
        testB();
    }

    public void testB() {
        System.out.println("testB执行");
        ((SimpleAopBean) AopContext.currentProxy()).testC();
    }

    public void testC() {
        System.out.println("testC执行");
    }

}
