package com.maple.demo.controller;

import com.maple.demo.bean.User;
import com.maple.demo.config.GlobalConfigs;
import com.maple.demo.service.UserService;
import com.maple.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {


	@Autowired
	private UserService userService;

    public String message(int status, String content) {
        return "{\"status\":\"" + status + "\",\"content\":\"" + content + "\"}";
    }

    Map<String, Object> messageToMap(int status, Object content) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("content", content);
        return map;
    }

    User getUser(HttpServletRequest request){
        String token = request.getHeader("token");
        String loginId = request.getHeader("loginId");
        User user = null;
        if(!StringUtils.isEmpty(loginId) && !StringUtils.isEmpty(token)){
            Integer id = Integer.valueOf(loginId);
            String tokenRedis = RedisUtil.get(GlobalConfigs.getTokenKey(id));
            if(token.equals(tokenRedis)){
                user = userService.getById(id);
            }
        }
        return user;
    }

}
