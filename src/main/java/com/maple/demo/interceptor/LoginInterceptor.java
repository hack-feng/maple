package com.maple.demo.interceptor;


import com.maple.demo.utils.WebConfig;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //判断session是否存在
        HttpSession session = request.getSession(true);
        session.setAttribute(WebConfig.LOGIN_USER, "maple");

        //如果session不存在，则跳转到登录页
        if (session.getAttribute(WebConfig.LOGIN_USER) == null){
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        } else {
            session.setAttribute(WebConfig.LOGIN_USER, session.getAttribute(WebConfig.LOGIN_USER));
            return true;
        }
    }
}
