package com.maple.demo.controller;

import com.maple.demo.utils.LogHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso")
public class SsoController extends BaseController{

	@PostMapping(value = "/login")
	@LogHelper(logDesc = "日志", logType = logTypeEnum.LOGIN, operType = operTypeEnum.SELECT)
	public String login(String username, String password) {
		System.out.println(username);
		System.out.println(password);

		return "aaa";
	}
}
