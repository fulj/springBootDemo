package com.example.demo.proxy.JDK;

/**
 * @author fulj
 * @date 2019年06月30日 2:44 PM
 */
public class WangMeiLi implements Girl {
    @Override
    public void date() {
        System.out.println("王美丽说：跟你约会好开心");
    }

    @Override
    public void watchMovie() {
        System.out.println("王美丽说：这个电影一点也不好看");
    }
}
