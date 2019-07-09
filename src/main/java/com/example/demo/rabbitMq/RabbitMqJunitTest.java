package com.example.demo.rabbitMq;

import com.example.demo.DemoApplication;
import com.example.demo.rabbitMq.direct_route.DirectSender;
import com.example.demo.rabbitMq.pub_sub.PubSender;
import com.example.demo.rabbitMq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RabbitMqJunitTest {
    //发布
    @Autowired
    private PubSender pubSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    public TopicSender topicSender;

    /**
     * 测试发布-订阅模式,广播
     */
    @Test
    public void fanoutSenderTest(){
        for(int i =0;i<100;i++) {
            pubSender.send();
        }
    }

    /**
     * 测试路由键绑定模式 routing-key binding
     */
    @Test
    public void directSenderTest(){
        for (int i = 0; i < 100; i++) {
            directSender.send();
        }
    }

    @Test
    public void topicSenderTest(){
        for (int i = 0; i < 100000; i++) {
            topicSender.send();
        }
    }
}
