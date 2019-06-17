package com.maple.demo.interceptor;


import com.maple.demo.config.WebMvcConfig;
import org.springframework.web.servlet.HandlerInterceptor;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //判断session是否存在
        HttpSession session = request.getSession(true);
        session.setAttribute(WebMvcConfig.LOGIN_USER,"maple");
        System.out.println(session.getAttribute(WebMvcConfig.LOGIN_USER));

        //如果session不存在，转发到/sso/index请求上，该请求暂不存在
        if (session.getAttribute(WebMvcConfig.LOGIN_USER) == null){
            response.sendRedirect("http://127.0.0.1:8083/login");
            return false;
        } else {
            //刷新session的值，每次成功访问刷新失效时间
            session.setAttribute(WebMvcConfig.LOGIN_USER, session.getAttribute(WebMvcConfig.LOGIN_USER));
            return true;
        }
    }
}
