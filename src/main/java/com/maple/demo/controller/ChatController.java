package com.maple.demo.controller;

import com.maple.demo.bean.User;
import com.maple.demo.service.MessageService;
import com.maple.demo.service.UserService;
import com.maple.demo.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController extends BaseController{

    @Autowired
    private WebSocket webSocket;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    /**
     * 获取好友列表
     * @return
     */
    @PostMapping("/getList")
    public Map<String, Object> getList(){
        List<User> userList = userService.list(null);
        return messageToMap(Type.success, userList);
    }

    /**
     * 跳到好友聊天框，获取聊天记录
     * @param friendId
     * @return
     */
    @PostMapping("/getMessageList")
    public Map<String, Object> getMessageList(Integer friendId, HttpSession session){
        User user = getUser(session);
        User friendInfo = userService.getById(friendId);
        List<Map> message = messageService.getMessageList(friendId, user.getId());
        Map result = new HashMap();
        result.put("message", message);
        result.put("friendInfo", friendInfo);
        return messageToMap(Type.success, result);
    }

    @GetMapping("/sendAllWebSocket")
    public String test(){
        String text = "你们好！这是webSocket群体发送！";
        webSocket.sendAllMessage(text);
        return text;
    }

    @GetMapping("/sendMessage")
    public String test(String userName){
        String text = "你们好！这是webSocket单人发送！";
        webSocket.sendOneMessage(userName,text);
        return text;
    }
}
