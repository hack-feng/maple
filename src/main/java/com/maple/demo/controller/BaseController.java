package com.maple.demo.controller;

public class BaseController {

    /**
     * 日志-日志类型
     */
    public enum logTypeEnum{
        //登录
        LOGIN,
        //接口
        INTERFACE,
        //业务
        BUSINESS

    }

    /**
     * 日志-操作类型
     */
    public enum operTypeEnum{
        SELECT,
        INSERT,
        UPDATE,
        DELETE
    }
}
