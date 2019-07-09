package com.maple.demo.dao;

import com.maple.demo.bean.LogSystemLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 日志信息-系统日志表 Mapper 接口
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Mapper
public interface LogSystemLogMapper extends BaseMapper<LogSystemLog> {

}
