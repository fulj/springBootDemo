package com.example.demo.rabbitMq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicExchangeConfig {

    /**
     * 主题交换器
     * @return
     */
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    private static class TopicConfig{
        @Bean
        public Queue autoDeleteQueue5() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue6() {
            return new AnonymousQueue();
        }

        //              *.orange.* ->queue5
        // tut.topic -> *.*.rabbit->queue5
        //              lazy.#    ->queue6

        //星号匹配一个单词，哈希号匹配多个单词
        @Bean
        public Binding binding3a(TopicExchange topic, Queue autoDeleteQueue5){
            return BindingBuilder.bind(autoDeleteQueue5).to(topic).with("*.orange.*");
        }

        @Bean
        public Binding binding3b(TopicExchange topic,Queue autoDeleteQueue5){
            return BindingBuilder.bind(autoDeleteQueue5).to(topic).with("*.*.rabbit");
        }

        @Bean
        public Binding binding4a(TopicExchange topic,Queue autoDeleteQueue6){
            return BindingBuilder.bind(autoDeleteQueue6).to(topic).with("lazy.#");
        }

    }

}
