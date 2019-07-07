package com.example.demo.spiDemo;

/**
 * @author fulj
 * @date 2019年07月07日 7:49 PM
 */
public class Bird implements IFly {
    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }
}
