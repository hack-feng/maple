package com.maple.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maple.demo.bean.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-05-03
 */
public interface UserService extends IService<User> {

    User userLogin(String username, String password);
}
