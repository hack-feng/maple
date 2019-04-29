package com.maple.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2019-04-30
 */
@Getter
@Setter
@ToString
@TableName("maple_system_log")
public class SystemLog extends Model<SystemLog> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 参数
     */
	private String params;
    /**
     * 返回结果
     */
	private String results;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 请求ip
     */
	@TableField("request_ip")
	private String requestIp;
    /**
     * 请求路径
     */
	@TableField("all_method_name")
	private String allMethodName;
    /**
     * 请求方法名称
     */
	@TableField("method_name")
	private String methodName;
    /**
     * 操作方式
     */
	@TableField("operation_type")
	private String operationType;
    /**
     * 是否成功
     */
	private String success;
    /**
     * 响应时间
     */
	@TableField("resp_time")
	private String respTime;
    /**
     * 错误信息
     */
	@TableField("error_msg")
	private String errorMsg;
    /**
     * 操作人id
     */
	@TableField("operate_id")
	private Integer operateId;
    /**
     * 操作人姓名
     */
	@TableField("operate_name")
	private String operateName;
    /**
     * 日志类型
     */
    @TableField("log_type")
	private String logType;
	/**
	 * 日志描述
	 */
	@TableField("log_desc")
	private String logDesc;
}
