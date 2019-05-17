package com.maple.demo.config;

public class GlobalConfigs {

    /**
     *  windows   ---配置
     */

    //文件上传目录
    public static final String UPLOAD_URL = "D:/data/img/";

    //文件上传返回的路径
    public static final String BASE_FILE_URL = "/data/";

    //配置器配置拦截的文件
    public static final String RESOURCE_HANDLER = "/data/**";

    //配置器替换的路径
    public static final String RESOURCE_LOCATION = "file:D:/data/img/";


    /**
     * linux  ---配置


    //文件上传目录
    public static final String UPLOAD_URL = "/usr/local/upload/";

    //文件上传返回的路径
    public static final String BASE_FILE_URL = "/data/";

    //配置器配置拦截的文件
    public static final String RESOURCE_HANDLER = "/data/**";

    //配置器替换的路径
    public static final String RESOURCE_LOCATION = "/usr/local/upload/";

     */
}
