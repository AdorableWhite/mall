package com.taizilibai.mall.config.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Date: 2020/9/22 19:51
 */
public class SimpleSender {
    private static final Logger logger = LoggerFactory.getLogger(SimpleSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String queueName = "simple.hello";

    private static int i=0;
    public void send() {
        String message = "hello world";
        this.rabbitTemplate.convertAndSend(queueName, message);

        logger.info("send :" + (++i));
    }
}
