package com.maple.demo.config;

import com.maple.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 我的配置信息
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

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
        registry.addInterceptor(getSessionInterceptor())
                .addPathPatterns("/**","/main.html")
                .excludePathPatterns("/sso/**","/v2/**");
    }

    //用户登录存放的session
    public static final String LOGIN_USER = "MAPLE_LOGIN_USER";

    /**
     * 配置jsp页面
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler(GlobalConfigs.RESOURCE_HANDLER).addResourceLocations(GlobalConfigs.WIN_RESOURCE_LOCATION);
        }else {
            registry.addResourceHandler(GlobalConfigs.RESOURCE_HANDLER).addResourceLocations(GlobalConfigs.LINUX_RESOURCE_LOCATION);
        }

    }

    /**
     * 跨域处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    /**
     * 注入ServerEndpointExporter，
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
