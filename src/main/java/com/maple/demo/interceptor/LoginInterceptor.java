package com.maple.demo.interceptor;


import com.maple.demo.config.WebConfig;
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

        System.out.println(session.getAttribute(WebConfig.LOGIN_USER));

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
