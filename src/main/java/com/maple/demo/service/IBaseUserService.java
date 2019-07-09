package com.maple.demo.service;

import com.maple.demo.bean.BaseUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 基础信息-用户信息 服务类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
public interface IBaseUserService extends IService<BaseUser> {
    BaseUser userLogin(String username, String password);
}
