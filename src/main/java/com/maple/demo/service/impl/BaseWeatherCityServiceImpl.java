package com.maple.demo.service.impl;

import com.maple.demo.bean.BaseWeatherCity;
import com.maple.demo.dao.BaseWeatherCityMapper;
import com.maple.demo.service.IBaseWeatherCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基础信息-天气城市表 服务实现类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Service
public class BaseWeatherCityServiceImpl extends ServiceImpl<BaseWeatherCityMapper, BaseWeatherCity> implements IBaseWeatherCityService {

}
