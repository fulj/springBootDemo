package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fulj
 * @date 2019年07月12日 10:05 AM
 */
public class TestOOM {
    private byte[] aByte = new byte[10 * 1024 * 1024];

    public static void main(String[] args) {
        while (true) {
            List list = new ArrayList();
            list.add(new TestOOM());
        }
    }
}
