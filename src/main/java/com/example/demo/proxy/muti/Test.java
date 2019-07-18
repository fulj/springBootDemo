package com.example.demo.proxy.muti;

public class Test {

    public static void main(String[] args) {
        Object proxy = ProxyFactory.create().getProxy(new SayHello());
        ((SayHello) proxy).toString1();
    }


    static class SayHello {

//        @Override
        public String toString1() {
            return "hello cglib !";
        }
    }
}