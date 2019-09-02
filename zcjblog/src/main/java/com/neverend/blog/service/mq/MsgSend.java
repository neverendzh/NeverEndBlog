package com.neverend.blog.service.mq;

import com.neverend.blog.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MsgSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private  MessageReceive receiver;
    @Autowired
    private ConfigurableApplicationContext context;


    public void send(Object o)  {
        rabbitTemplate.convertAndSend(RabbitMQConfig.queueName, o);
//        context.close();
    }

}
