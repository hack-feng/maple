package com.maple.demo.controller;

import com.maple.demo.config.WebConfig;
import com.maple.demo.service.UserService;
import com.maple.demo.utils.LogHelper;
import com.maple.demo.utils.SendEmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sso")
public class SsoController extends BaseController{


	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	@LogHelper(logDesc = "用户登录", logType = logTypeEnum.LOGIN, operType = operTypeEnum.SELECT)
	public String login(String username, String password, String imgCode, HttpServletRequest request) {

		try {
			boolean isOk = userService.userLogin(username, password);
			if (isOk){
				request.getSession().setAttribute(WebConfig.LOGIN_USER, username);
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

	@RequestMapping(value = "sendEmail")
	public String sendEmail(){
		SendEmailUtils a = new SendEmailUtils();
		a.sendEmail("246843101@qq.com", "测试", "ceshi");
		return message(Type.success, "发送成功");
	}

}
