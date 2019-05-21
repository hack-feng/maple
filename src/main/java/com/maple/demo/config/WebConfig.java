package com.maple.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //用户登录存放的session
    public static final String LOGIN_USER = "LOGIN_USER";

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
}
