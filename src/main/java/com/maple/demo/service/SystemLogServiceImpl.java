package com.maple.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maple.demo.bean.SystemLog;
import com.maple.demo.dao.SystemLogMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-04-30
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {
	
}
