package com.maple.demo.service.impl;

import com.maple.demo.bean.LogSystemLog;
import com.maple.demo.dao.LogSystemLogMapper;
import com.maple.demo.service.ILogSystemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志信息-系统日志表 服务实现类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Service
public class LogSystemLogServiceImpl extends ServiceImpl<LogSystemLogMapper, LogSystemLog> implements ILogSystemLogService {

}
