package com.maple.demo.service;

import com.maple.demo.bean.ChatMessage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聊天模块-聊天信息 服务类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
public interface IChatMessageService extends IService<ChatMessage> {
    List<Map> getMessageList(Integer friendId, Integer userId);
}
