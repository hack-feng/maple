package com.maple.demo.interceptor;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.servlet.HandlerInterceptor;

import com.maple.demo.bean.User;
import com.maple.demo.config.WebConfig;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //判断session是否存在
        HttpSession session = request.getSession(true);

        System.out.println(session.getAttribute(WebConfig.LOGIN_USER));
        session.setAttribute(WebConfig.LOGIN_USER, "maple");

        //如果session不存在，转发到/sso/index请求上，该请求暂不存在
        if (session.getAttribute(WebConfig.LOGIN_USER) == null){
            response.sendRedirect(request.getContextPath()+"/sso/index");
            return false;
        } else {
            //刷新session的值，每次成功访问刷新失效时间
            session.setAttribute(WebConfig.LOGIN_USER, session.getAttribute(WebConfig.LOGIN_USER));
            return true;
        }
    }
}
