package com.maple.demo.controller;

import com.maple.demo.utils.CSDNCrawlerUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CSDN爬虫工具
 * @author Feng
 *
 */
@RestController
@RequestMapping("/crawler")
public class CrawlerController {

	/**
	 * 获取我的博客的列表
	 * @param about
	 * @param num
	 * @param readNum
	 * @return
	 */
	@PostMapping(value = "/start")
	public List<Map<String, Object>> start(String about, Integer num, Integer readNum) {
		List<Map<String, Object>> result = new ArrayList<>();

		result = CSDNCrawlerUtils.csdn_crawler("123", 1, 1);

		return result;
	}

	@PostMapping(value = "/getCsdnByAbout")
	public List<Map<String, Object>> getCsdnByAbout(String about, Integer num, Integer readNum){
		List<Map<String, Object>> result = new ArrayList<>();

		result = CSDNCrawlerUtils.csdn_about(about, 1, 1);

		return result;
	}
}
