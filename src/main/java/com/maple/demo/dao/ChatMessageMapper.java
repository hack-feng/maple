package com.maple.demo.dao;

import com.maple.demo.bean.ChatMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聊天模块-聊天信息 Mapper 接口
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Mapper
public interface ChatMessageMapper extends BaseMapper<ChatMessage> {
    List<Map> getMessageList(@Param("friendId") Integer friendId, @Param("userId") Integer userId);
}
