package com.maple.demo.controller;

import com.alibaba.fastjson.JSON;
import com.maple.demo.bean.User;
import com.maple.demo.config.GlobalConfigs;
import com.maple.demo.config.StatusConfigs;
import com.maple.demo.config.WebMvcConfig;
import com.maple.demo.service.UserService;
import com.maple.demo.utils.LogHelper;
import com.maple.demo.utils.RedisUtil;
import com.maple.demo.utils.SendEmailUtils;
import com.maple.demo.utils.WeatherUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/sso")
public class SsoController extends BaseController{


	@Autowired
	private UserService userService;
	@Autowired
	private WeatherUtil weatherUtil;

	@RequestMapping(value = "/login")
	@ApiOperation(value = "用户登录", notes = "根据用户名、密码、图片验证码登录系统")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "用户详细实体user", required = true, dataType = "String"),
			@ApiImplicitParam(name = "imgCode", value = "图片验证码", required = true, dataType = "String")})
	@LogHelper(logDesc = "用户登录", logType = GlobalConfigs.logTypeEnum.LOGIN, operType = GlobalConfigs.operTypeEnum.SELECT)
	@CrossOrigin
	public Map<String, Object> login(String username, String password, String imgCode, HttpServletRequest request) {
		System.out.println(request.getHeader("token"));
		try {
			User user = userService.userLogin(username, password);
			if (user != null && user.getId() != null){
				//存放用户登录session信息，将session放在redis数据库，实现分布式session
				String token = UUID.randomUUID().toString().replace("-", "");
				Integer id = user.getId();
				RedisUtil.put(GlobalConfigs.getTokenKey(user.getId()), token, GlobalConfigs.TOKEN_CACHE_TIME);
				Map<String, Object> map = new HashMap<>();
				map.put("loginId", id);
				map.put("token", token);
				map.put("content", "登录成功");
				return messageToMap(StatusConfigs.OK, map);
			} else{
				return messageToMap(StatusConfigs.NOT_OK, "登录失败，请重试！");
			}
		} catch (RuntimeException e){
			e.printStackTrace();
			return messageToMap(StatusConfigs.NOT_OK, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return messageToMap(StatusConfigs.ERROR, "系统错误，请稍候再试！");
		}
	}

	/**
	 * 发送邮件信息，使用了rabbitMQ异步发送
	 * @return
	 */
	@RequestMapping(value = "sendEmail")
	@LogHelper(logDesc = "发送邮件信息", logType = GlobalConfigs.logTypeEnum.BUSINESS, operType = GlobalConfigs.operTypeEnum.SELECT)
	public String sendEmail(String receiverMail, String title, String content){
		SendEmailUtils a = new SendEmailUtils();
		a.sendEmail(receiverMail, title, content);
		return message(StatusConfigs.OK, "发送成功");
	}

	@RequestMapping(value = "test")
	public String test(){
		List<String> list = new ArrayList<>();
		list.add("101120210");
		List<String> result = weatherUtil.getWeather(list);
		String a = JSON.toJSONString(result);
		return a;
	}

}
