package com.example.demo.spiDemo;

import java.util.ServiceLoader;

/**
 * @author fulj
 * @date 2019年07月07日 7:51 PM
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IFly> flys = ServiceLoader.load(IFly.class);
        for (IFly fly : flys) {
            fly.fly();
        }
    }
}
