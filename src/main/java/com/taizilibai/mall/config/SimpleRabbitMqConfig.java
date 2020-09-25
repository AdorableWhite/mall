package com.taizilibai.mall.config;

import com.taizilibai.mall.config.domain.SimpleReceiver;
import com.taizilibai.mall.config.domain.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/9/22 19:47
 */
@Configuration
public class SimpleRabbitMqConfig {


    @Bean
    public Queue hello() {
        return new Queue("simple.hello");
    }

    @Bean
    public SimpleSender simpleSender() {
        return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver() {
        return new SimpleReceiver();
    }


}
