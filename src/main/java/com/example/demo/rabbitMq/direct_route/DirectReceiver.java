package com.example.demo.rabbitMq.direct_route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class DirectReceiver {
    private Logger logger = LoggerFactory.getLogger(DirectReceiver.class);

    @RabbitListener(queues="#{autoDeleteQueue3.name}")
    public void receive3(String in ) throws InterruptedException{
        receive(in,3);
    }

    @RabbitListener(queues="#{autoDeleteQueue4.name}")
    public void receive4(String in ) throws InterruptedException{
        receive(in,4);
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
