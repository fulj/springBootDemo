package com.example.demo.test;

/**
 * @author fulj
 * @date 2019年07月12日 7:37 AM
 */
public class TestJVM {
    public static void main(String[] args) {
        String str = System.getProperty("str");
        if (str == null) {
            System.out.println("null");
        }else{
            //加这个参数可以打印java -Dstr TestJVM
            System.out.println("hello");
        }
    }
}
