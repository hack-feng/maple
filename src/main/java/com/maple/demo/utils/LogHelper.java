package com.maple.demo.utils;

import com.maple.demo.controller.BaseController;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogHelper {

    //日志描述
    String logDesc() default "";

    //操作类型
    BaseController.operTypeEnum operType();

    //日志类型（0：登录 1：业务 2：接口）
    BaseController.logTypeEnum logType();
}