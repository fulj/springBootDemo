package com.example.demo.rabbitMq.pub_sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author fulj
 * @date 2019年07月09日 2:42 PM
 */
@Component
public class SubReceiver {
    private Logger logger = LoggerFactory.getLogger(SubReceiver.class);

    @RabbitListener(queues="#{autoDeleteQueue1.name}")
    public void receive1(String in ) throws InterruptedException{
        receive(in,1);
    }

    @RabbitListener(queues="#{autoDeleteQueue2.name}")
    public void receive2(String in ) throws InterruptedException{
        receive(in,2);
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
