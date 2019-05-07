package com.maple.demo.controller;

import com.maple.demo.bean.User;
import com.maple.demo.service.UserService;
import com.maple.demo.utils.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/sso")
public class SsoController extends BaseController{


	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	@LogHelper(logDesc = "用户登录", logType = logTypeEnum.LOGIN, operType = operTypeEnum.SELECT)
	public String login(String username, String password, String imgCode, HttpServletRequest request) {

		try {
			boolean isOk = userService.userLogin(username, password);
			if (isOk){
				return message(Type.success, "登录成功");
			} else{
				return message(Type.error, "登录失败，请重试！");
			}
		} catch (RuntimeException e){
			return message(Type.error, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return message(Type.error, "系统错误，请稍候再试！");
		}
	}
}
