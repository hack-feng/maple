package com.maple.demo.config.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    private static AmqpTemplate amqpTemplate;

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setChatService(AmqpTemplate amqpTemplate) {
        HelloSender.amqpTemplate = amqpTemplate;
    }

    public void send( SimpleMailMessage mainMessage) {
        amqpTemplate.convertAndSend("queue", mainMessage);
    }
}
