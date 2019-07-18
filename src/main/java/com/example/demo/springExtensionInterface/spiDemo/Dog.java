package com.example.demo.springExtensionInterface.spiDemo;

/**
 * @author fulj
 * @date 2019年07月07日 7:50 PM
 */
public class Dog implements IFly {
    @Override
    public void fly() {
        System.out.println("狗狗不会飞");
    }
}
