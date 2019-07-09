package com.maple.demo.service.impl;

import com.maple.demo.bean.ChatMessage;
import com.maple.demo.dao.ChatMessageMapper;
import com.maple.demo.service.IChatMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聊天模块-聊天信息 服务实现类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Service
public class ChatMessageServiceImpl extends ServiceImpl<ChatMessageMapper, ChatMessage> implements IChatMessageService {
    @Autowired
    private ChatMessageMapper messageMapper;

    @Override
    public List<Map> getMessageList(Integer friendId, Integer userId) {
        return messageMapper.getMessageList(friendId, userId);
    }
}
