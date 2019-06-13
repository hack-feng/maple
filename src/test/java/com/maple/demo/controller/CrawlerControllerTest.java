package com.maple.demo.controller;

import com.maple.demo.utils.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class CrawlerControllerTest {

	/**
	 * 测试获取我的博客列表
	 */
	@Test
	public void start() {
		Map<String, Object> map = new HashMap<>();
		map.put("about","12312");
		map.put("num",10);
		map.put("readNum",10);
		String result = HttpUtil.post("http://127.0.0.1:8044/crawler/start", map, 3000, 3000, "UTF-8");
		System.out.println(result);

	}

	/**
	 * 测试根据输入的关键字获取博客列表
	 */
	@Test
	public void getCsdnByAbout() {
		Map<String, Object> map = new HashMap<>();
		map.put("about","浏览器使用华视电子设备读取身份证信息");
		map.put("num",10);
		map.put("readNum",1000);
		String result = HttpUtil.post("http://127.0.0.1:8044/crawler/getCsdnByAbout", map, 3000, 3000, "UTF-8");
		System.out.println(result);
	}
}
