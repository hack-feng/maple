package com.maple.demo.controller;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 定义返回类型
     */
    public enum Type {
        success,
        error
    }

    public String message(Type type, String content) {
        return "{\"type\":\"" + (type == Type.success ? "success" : "error") + "\",\"content\":\"" + content + "\"}";
    }

    public String message(Type type, String content, Object... args) {
        for (Object object : args) {
            object.toString();
        }
        return "{\"type\":\"" + (type == Type.success ? "success" : "error") + "\",\"content\":\"" + content + "\"}";
    }

    public Map<String, Object> messageToMap(Type type, Object content) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type == Type.success ? "success" : "error");
        map.put("content", content);
        return map;
    }
}
