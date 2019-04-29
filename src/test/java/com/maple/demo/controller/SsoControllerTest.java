package com.maple.demo.controller;

import static org.junit.Assert.*;

import com.maple.demo.utils.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SsoControllerTest {

	@Test
	public void testLogin() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "maple");
		map.put("password", "123456");

		String result = HttpUtil.post("http://127.0.0.1:8081/sso/login", map, 3000, 3000, "UTF-8");
		System.out.println(result);
	}

}
