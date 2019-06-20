package com.maple.demo.interceptor;


import com.maple.demo.config.GlobalConfigs;
import com.maple.demo.config.WebMvcConfig;
import com.maple.demo.utils.RedisUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        Map map = request.getParameterMap();
        if(map != null && map.get("id") != null){
            Integer id = Integer.valueOf(map.get("id").toString());
            String token = map.get("token").toString();
            String tokenRedis = RedisUtil.get(GlobalConfigs.getTokenKey(id));
            if(!token.equals(tokenRedis)){
                response.sendRedirect("http://127.0.0.1:8083/login");
                return false;
            }else{
                //刷新redis的值，每次成功访问刷新失效时间
                RedisUtil.put(GlobalConfigs.getTokenKey(id), token, GlobalConfigs.TOKEN_CACHE_TIME);
                return true;
            }
        }else{
            response.sendRedirect("http://127.0.0.1:8083/login");
            return false;
        }
    }
}
