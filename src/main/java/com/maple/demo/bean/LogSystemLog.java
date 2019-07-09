package com.maple.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 日志信息-系统日志表
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@TableName("log_system_log")
@ApiModel(value="LogSystemLog对象", description="日志信息-系统日志表")
public class LogSystemLog extends Model<LogSystemLog> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "日志参数")
    private String params;

    @ApiModelProperty(value = "返回结果")
    private String results;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty(value = "请求ip")
    @TableField("request_ip")
    private String requestIp;

    @ApiModelProperty(value = "请求路径")
    @TableField("all_method_name")
    private String allMethodName;

    @ApiModelProperty(value = "请求方法名称")
    @TableField("method_name")
    private String methodName;

    @ApiModelProperty(value = "操作方式")
    @TableField("operation_type")
    private String operationType;

    @ApiModelProperty(value = "是否成功（0：否 1：是）")
    private String success;

    @ApiModelProperty(value = "响应时间")
    @TableField("resp_time")
    private String respTime;

    @ApiModelProperty(value = "错误信息")
    @TableField("error_msg")
    private String errorMsg;

    @ApiModelProperty(value = "操作人id")
    @TableField("operate_id")
    private Integer operateId;

    @ApiModelProperty(value = "操作人姓名")
    @TableField("operate_name")
    private String operateName;

    @ApiModelProperty(value = "日志类型")
    @TableField("log_type")
    private String logType;

    @ApiModelProperty(value = "日志描述")
    @TableField("log_desc")
    private String logDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getAllMethodName() {
        return allMethodName;
    }

    public void setAllMethodName(String allMethodName) {
        this.allMethodName = allMethodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LogSystemLog{" +
        ", id=" + id +
        ", params=" + params +
        ", results=" + results +
        ", createDate=" + createDate +
        ", requestIp=" + requestIp +
        ", allMethodName=" + allMethodName +
        ", methodName=" + methodName +
        ", operationType=" + operationType +
        ", success=" + success +
        ", respTime=" + respTime +
        ", errorMsg=" + errorMsg +
        ", operateId=" + operateId +
        ", operateName=" + operateName +
        ", logType=" + logType +
        ", logDesc=" + logDesc +
        "}";
    }
}
