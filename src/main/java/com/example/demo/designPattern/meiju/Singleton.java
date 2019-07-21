package com.example.demo.designPattern.meiju;

/**
 * 线程安全，所以不需要double checked locking,
 * 而且还能防止反序列化导致重新创建新的对象。保证只有一个实例（即使使用反射也无法多次实例化一个对象）
 */
public class Singleton {
    public static void main(String[] args) {
        Single single = Single.S;
        single.print();
    }
    enum Single{
        S;
        private Single(){}
        public void print(){
            System.out.println("hello world");
        }
    }
}
