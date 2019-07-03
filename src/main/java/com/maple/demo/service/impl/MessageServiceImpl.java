package com.maple.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maple.demo.bean.Message;
import com.maple.demo.dao.MessageMapper;
import com.maple.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-06-10
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Map> getMessageList(Integer friendId, Integer userId) {
        return messageMapper.getMessageList(friendId, userId);
    }
}
