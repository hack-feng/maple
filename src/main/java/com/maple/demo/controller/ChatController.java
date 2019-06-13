package com.maple.demo.controller;

import com.maple.demo.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private WebSocket webSocket;

    @GetMapping("/sendAllWebSocket")
    public String test(){
        String text = "你们好！这是webSocket群体发送！";
        webSocket.sendAllMessage(text);
        return text;
    }

    @GetMapping("/sendAllWebSocket/{userName}")
    public String test(@PathVariable("userName") String userName){
        String text = "你们好！这是webSocket单人发送！";
        webSocket.sendOneMessage(userName,text);
        return text;
    }
}
