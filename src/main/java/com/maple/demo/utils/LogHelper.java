package com.maple.demo.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.maple.demo.config.GlobalConfigs;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogHelper {

    //日志描述
    String logDesc() default "";

    //操作类型
    GlobalConfigs.operTypeEnum operType();

    //日志类型（0：登录 1：业务 2：接口）
    GlobalConfigs.logTypeEnum logType();
}