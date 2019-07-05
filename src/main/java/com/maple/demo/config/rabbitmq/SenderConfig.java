package com.maple.demo.config.rabbitmq;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    //队列配置--发送邮件
    @Bean
    public Queue queue() {
        return new Queue("sendEmail");
    }

    //队列配置--保存聊天消息的队列
    @Bean
    public Queue saveChatMsgQueue(){
        return new Queue("saveChatMsgQueue");
    }
}
