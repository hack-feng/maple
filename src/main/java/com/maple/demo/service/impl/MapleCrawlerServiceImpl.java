package com.maple.demo.service.impl;

import com.maple.demo.bean.MapleCrawler;
import com.maple.demo.dao.MapleCrawlerMapper;
import com.maple.demo.service.IMapleCrawlerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 爬虫模块-CSDN文章表 服务实现类
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@Service
public class MapleCrawlerServiceImpl extends ServiceImpl<MapleCrawlerMapper, MapleCrawler> implements IMapleCrawlerService {

}
