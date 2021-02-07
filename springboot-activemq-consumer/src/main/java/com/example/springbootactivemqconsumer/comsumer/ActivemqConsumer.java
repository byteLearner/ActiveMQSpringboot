package com.example.springbootactivemqconsumer.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @description:消费者
 * @author: liuqiang
 * @time: 2021/2/7 15:50
 */
@Component
public class ActivemqConsumer {


    @JmsListener(destination = "${myQueue}")
    public void acitvemqListern(TextMessage textMessage) throws JMSException {
        System.out.println("收到消息"+textMessage.getText());
    }
}
