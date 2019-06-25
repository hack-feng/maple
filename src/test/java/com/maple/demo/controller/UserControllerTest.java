package com.maple.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maple.demo.utils.HttpUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class UserControllerTest {

	/**
	 * 测试登录拦截器
	 */
	@Test
	public void testLogin() {
		Map map = new HashMap();
		String url = "http://t.weather.sojson.com/api/weather/city/101030100";
		String result = HttpUtil.get(url, map, 5000,5000, "UTF-8");
		System.out.println(result);
		Map<String, Object> mapFlag = (Map<String, Object>) JSONObject.parse(result);
		System.out.println(mapFlag.get("time"));
//		Map map = new HashMap();
//		String result = HttpUtil.post("http://127.0.0.1:8044/user/test", map, 3000, 3000, "UTF-8");
	}

}
