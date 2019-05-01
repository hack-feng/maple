package com.maple.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 用户登录拦截器
         * 拦截除了/sso请求下的所有请求
         */
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**","/main.html").excludePathPatterns("/sso/**");
    }
}
