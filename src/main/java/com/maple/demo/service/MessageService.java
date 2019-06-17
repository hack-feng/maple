package com.maple.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maple.demo.bean.Message;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-06-10
 */
public interface MessageService extends IService<Message> {

    List<Map> getMessageList(Integer friendId, Integer userId);
}
