package com.maple.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maple.demo.bean.User;
import com.maple.demo.dao.UserMapper;
import com.maple.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-05-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean userLogin(String username, String password) throws RuntimeException{
        User user = this.baseMapper.selectOne(new QueryWrapper<User>().eq("user_name", username).eq("is_delete", 0));
        if (user == null){
            throw new RuntimeException("该用户不存在！");
        }

        if (!user.getPassWord().equals(password)){
            throw new RuntimeException("用户名或密码错误！");
        }

        if (user.getIsLock().equals(1)){
            throw new RuntimeException("该用户被锁定！");
        }
        return true;
    }
}
