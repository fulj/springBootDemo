package com.example.demo.rabbitMq.pub_sub;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqPubSubExchangeConfig {

    /**
     * rabbit 三种交换器中的广播交换器
     * @return
     */
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("fulj.fanout");
    }

    private static class FanoutConfig {

        //AnonymousQueue类型的队列，它的名字是由客户端生成的，而且是非持久的，独占的，自动删除的队列
        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }

        //队列和交换机绑定
        //这种关系可以读作：这个队列对这个交换器里的消息感兴趣。
        //虽然 Queue类型有多个实例，但spring会自动更加名字匹配，bean名字匹配参数名字
        @Bean
        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }
    }


}
