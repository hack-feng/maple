package com.maple.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maple.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-05-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}