package com.maple.demo.utils;

import com.maple.demo.config.rabbitmq.HelloSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtils {

    public void sendEmail(String receiverMail, String title, String content){
        HelloSender helloSender = new HelloSender();
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("1150640979@qq.com");
        //接收者
        mainMessage.setTo(receiverMail);
        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(content);
        //调用发送者
        helloSender.send(mainMessage);

    }
}
