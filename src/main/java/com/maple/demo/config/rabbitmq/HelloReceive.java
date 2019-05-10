package com.maple.demo.config.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {

    @Autowired()
    private JavaMailSender javaMailSender;

    @RabbitListener(queues = "queue")
    public void processC(SimpleMailMessage mainMessage){

        System.out.println("receive" + mainMessage);
        mainMessage.setFrom("1150640979@qq.com");
        javaMailSender.send(mainMessage);

    }
}
