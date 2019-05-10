package com.maple.demo.config;

import com.maple.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getSessionInterceptor() {
        return new LoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 用户登录拦截器
         * 拦截除了/sso请求下的所有请求
         */
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/**","/main.html").excludePathPatterns("/sso/**");
    }
}
