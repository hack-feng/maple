package com.maple.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maple.demo.bean.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-06-10
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}