package com.maple.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.maple.demo.bean.Message;
import com.maple.demo.config.rabbitmq.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocket{

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //我的id
    private static String myId;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    //创建一个线程安全的map
    private static Map<String, Session> sessionPool = new HashMap<>();
    @Autowired
    private HelloSender helloSender;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId){
        myId = userId;
        this.session = session;
        webSockets.add(this);
        sessionPool.put(userId, session);
        System.out.println(userId+"【webSocket消息】有新的连接，总数为："+webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void  onMessage(String msgData){
//        User user = getUser(httpSession);
        String[] flag = msgData.split("&");
        JSONObject jsonObject = JSONObject.parseObject(msgData);
        String message = String.valueOf(jsonObject.get("message"));
        String friendId = jsonObject.get("friendId").toString();
        System.out.println(friendId+"【websocket消息】收到客户端消息:"+message);
        sendOneMessage(friendId, message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误 session: "+session);
        error.printStackTrace();
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息
    public void sendOneMessage(String userId, String message) {
        System.out.println("【websocket消息】单点消息:"+message);
        Session session = sessionPool.get(userId);
        if (session != null) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("message", message);
                map.put("createDate", new Date());
                map.put("userId",myId);
                String result = JSONObject.toJSONString(map);
                System.out.println(result);
                session.getAsyncRemote().sendText(result);

                // 将聊天消息放入mq，异步保存
                Message msg = new Message();
                msg.setCreateDate(new Date());
                msg.setMessageType("text");
                msg.setReciverUser(Integer.valueOf(userId));
                msg.setSendUser(Integer.valueOf(myId));
                msg.setStatus(1);
                msg.setType(1);
                msg.setMessage(message);
                helloSender.sendSaveChatMsgQueue(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
