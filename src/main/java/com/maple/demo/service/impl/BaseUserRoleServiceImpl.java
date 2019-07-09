package com.maple.demo.service.impl;

import com.maple.demo.bean.BaseUserRole;
import com.maple.demo.dao.BaseUserRoleMapper;
import com.maple.demo.service.IBaseUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基础信息-用户和角色关联表 服务实现类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Service
public class BaseUserRoleServiceImpl extends ServiceImpl<BaseUserRoleMapper, BaseUserRole> implements IBaseUserRoleService {

}
