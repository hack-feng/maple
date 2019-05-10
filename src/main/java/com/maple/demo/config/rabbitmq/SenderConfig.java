package com.maple.demo.config.rabbitmq;

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
}
