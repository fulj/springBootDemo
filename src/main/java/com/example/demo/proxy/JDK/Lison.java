package com.example.demo.proxy.JDK;

/**
 *客户端
 */
public class Lison {
    public static void main(String[] args) {
        //隔壁有个女孩叫王美丽
        Girl girl = new WangMeiLi();
        //他有个庞大的家庭跟他约会必须征得他家人的同意
        WangMeiLiProxy family = new WangMeiLiProxy(girl);
        //有一天我去约王美丽，碰到了他的妈妈，我征得了她妈妈的同意
        Girl mother = (Girl) family.getProxyInstance();
        //通过她的妈妈的这个代理我才能与王美丽约会
        mother.date();
        System.out.println("-----------------------------");
        mother.watchMovie();
    }
}
