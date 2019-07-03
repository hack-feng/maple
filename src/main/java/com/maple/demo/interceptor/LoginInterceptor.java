package com.maple.demo.interceptor;


import com.maple.demo.config.GlobalConfigs;
import com.maple.demo.config.WebMvcConfig;
import com.maple.demo.utils.RedisUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        return true;
//        String token = request.getHeader("token");
//        String loginId = request.getHeader("loginId");
//        if(!StringUtils.isEmpty(loginId) && !StringUtils.isEmpty(token)){
//            Integer id = Integer.valueOf(loginId);
//            String tokenRedis = RedisUtil.get(GlobalConfigs.getTokenKey(id));
//            if(!token.equals(tokenRedis)){
//                return false;
//            }else{
//                //刷新redis的值，每次成功访问刷新失效时间
//                RedisUtil.put(GlobalConfigs.getTokenKey(id), token, GlobalConfigs.TOKEN_CACHE_TIME);
//                return true;
//            }
//        }else{
//            return false;
//        }
    }
}
