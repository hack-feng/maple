package com.maple.demo.config.rabbitmq;

import com.maple.demo.bean.ChatMessage;
import com.maple.demo.service.IChatMessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {

    @Autowired(required=false)
    private JavaMailSender javaMailSender;
    @Autowired
    private IChatMessageService messageService;

    /**
     * 监听Rabbit下的sendEmail通道，处理消息队列中未处理的消息
     * @param mainMessage
     */
    @RabbitListener(queues = "sendEmail")
    public void processC(SimpleMailMessage mainMessage){

        //发送邮件
        javaMailSender.send(mainMessage);

    }

    /**
     * 异步保存聊天的消息
     * @param message
     */
    @RabbitListener(queues = "saveChatMsgQueue")
    public void saveChatMsgQueue(ChatMessage message){
        messageService.save(message);
    }
}
