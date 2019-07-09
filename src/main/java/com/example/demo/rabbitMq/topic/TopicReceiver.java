package com.example.demo.rabbitMq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class TopicReceiver {
    private Logger logger = LoggerFactory.getLogger(TopicReceiver.class);

    @RabbitListener(queues="#{autoDeleteQueue5.name}")
    public void receive5(String in ) throws InterruptedException{
        receive(in,5);
    }

    @RabbitListener(queues="#{autoDeleteQueue6.name}")
    public void receive6(String in ) throws InterruptedException{
        receive(in,6);
    }

    public void receive(String in, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        logger.info("instance " + receiver + " [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        logger.info("instance " + receiver + " [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}