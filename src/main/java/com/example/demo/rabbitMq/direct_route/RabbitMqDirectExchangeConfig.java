package com.example.demo.rabbitMq.direct_route;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectExchangeConfig {

    /**
     * 广播交换器
     * @return
     */
    @Bean
    public DirectExchange direct(){
        return  new DirectExchange("fulj.direct");
    }

    /**
     * @Bean 通过使用静态类封闭
     */
    private static class DirectConfig{

        @Bean
        public Queue autoDeleteQueue3() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue4() {
            return new AnonymousQueue();
        }

        //                orange  ->queue3
        //  tut.direct -> black   ->queue3,queue4
        //                green   ->queue4
        //

        @Bean
        public Binding binding1a(DirectExchange direct, Queue autoDeleteQueue3) {
            return BindingBuilder.bind(autoDeleteQueue3).to(direct).with("orange");
        }

        @Bean
        public Binding binding1b(DirectExchange direct, Queue autoDeleteQueue3) {
            return BindingBuilder.bind(autoDeleteQueue3).to(direct).with("black");
        }

        @Bean
        public Binding binding2a(DirectExchange direct, Queue autoDeleteQueue4) {
            return BindingBuilder.bind(autoDeleteQueue4).to(direct).with("green");
        }

        @Bean
        public Binding binding2b(DirectExchange direct, Queue autoDeleteQueue4) {
            return BindingBuilder.bind(autoDeleteQueue4).to(direct).with("black");
        }

    }

}