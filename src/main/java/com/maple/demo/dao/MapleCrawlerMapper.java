package com.maple.demo.dao;

import com.maple.demo.bean.MapleCrawler;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 爬虫模块-CSDN文章表 Mapper 接口
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Mapper
public interface MapleCrawlerMapper extends BaseMapper<MapleCrawler> {

}
