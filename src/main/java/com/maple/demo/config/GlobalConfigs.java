package com.maple.demo.config;

public class GlobalConfigs {

    /**
     *  windows   ---配置
     */

    //文件上传目录
    public static final String WIN_UPLOAD_URL = "D:/data/img/";
    
    //配置器替换的路径
    public static final String WIN_RESOURCE_LOCATION = "file:D:/data/img/";

    //文件上传返回的路径
    public static final String BASE_FILE_URL = "/data/";

    //配置器配置拦截的文件
    public static final String RESOURCE_HANDLER = "/data/**";

    /**
     * linux  ---配置
     */

    //文件上传目录
    public static final String LINUX_UPLOAD_URL = "/usr/local/upload/";

    //配置器替换的路径
    public static final String LINUX_RESOURCE_LOCATION = "/usr/local/upload/";
    
    
    /**
     * 日志-日志类型
     */
    public static enum logTypeEnum{
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
    public static enum operTypeEnum{
        SELECT,
        INSERT,
        UPDATE,
        DELETE
    }
     
}
