package com.taizilibai.mall.config.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/9/22 19:54
 */
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {

    private Logger logger = LoggerFactory.getLogger(SimpleReceiver.class);

    private static int i = 0;

    @RabbitHandler
    public void receive(String in){
        logger.info("receive: " + (++i) + " :" + in);
    }
}
