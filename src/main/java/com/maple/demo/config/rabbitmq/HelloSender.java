package com.maple.demo.config.rabbitmq;

import com.maple.demo.bean.ChatMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component()
public class HelloSender {

    private static AmqpTemplate amqpTemplate;

    // 注入amqpTemplate
    @Autowired
    public void setChatService(AmqpTemplate amqpTemplate) {
        HelloSender.amqpTemplate = amqpTemplate;
    }

    /**
     * 将消息放入rabbitMQ "sendEmail" 通道的消息队列
     * @param mainMessage
     */
    public void send( SimpleMailMessage mainMessage) {
        amqpTemplate.convertAndSend("sendEmail", mainMessage);
    }

    /**
     * 聊天信息放入"saveChatMsgQueue"通道的消息队列
     * @param message
     */
    public void sendSaveChatMsgQueue(ChatMessage message){
        amqpTemplate.convertAndSend("saveChatMsgQueue", message);
    }
}
