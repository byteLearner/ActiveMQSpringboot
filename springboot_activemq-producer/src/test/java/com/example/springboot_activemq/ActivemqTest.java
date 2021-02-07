package com.example.springboot_activemq;

import com.example.springboot_activemq.producer.ActiveMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @description:
 * @author: liuqiang
 * @time: 2021/2/7 14:22
 */
@SpringBootTest(classes = SpringbootActivemqApplication.class)
// 加载spring的junit

@RunWith(SpringJUnit4ClassRunner.class)

// 加载web

@WebAppConfiguration

public class ActivemqTest {
    @Resource
    private ActiveMQProducer activeMQProducer;

    @Test
    public void test() {
        activeMQProducer.send();
    }
}
