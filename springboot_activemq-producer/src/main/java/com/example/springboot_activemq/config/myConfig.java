package com.example.springboot_activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liuqiang
 * @time: 2021/2/7 14:18
 */
@Component
@EnableJms
public class myConfig {

    @Value("${myQueue}")
    private String activemqQueue;

    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue(activemqQueue);
    }
}
