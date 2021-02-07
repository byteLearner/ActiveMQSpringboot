package com.example.springboot_activemq.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @description:
 * @author: liuqiang
 * @time: 2021/2/7 14:20
 */
@Component
public class ActiveMQProducer {

    private JmsMessagingTemplate jmsMessagingTemplate;


    private ActiveMQQueue activeMQQueue;

    public void send() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, UUID.randomUUID().toString().substring(0,6));
    }

    //有参构造方法注入
    public ActiveMQProducer(JmsMessagingTemplate jmsMessagingTemplate, ActiveMQQueue activeMQQueue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.activeMQQueue = activeMQQueue;
    }

    // 定时任务。每3秒执行一次。非必须代码，仅为演示。
    @Scheduled(fixedDelay = 3000)
    public void produceMessageScheduled(){
        send();
    }
}
