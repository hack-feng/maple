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
 * 聊天模块-聊天信息
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@TableName("chat_message")
@ApiModel(value="ChatMessage对象", description="聊天模块-聊天信息")
public class ChatMessage extends Model<ChatMessage> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发送消息内容")
    private String message;

    @ApiModelProperty(value = "发送人id")
    @TableField("send_user")
    private Integer sendUser;

    @ApiModelProperty(value = "接收人id")
    @TableField("reciver_user")
    private Integer reciverUser;

    @ApiModelProperty(value = "发送时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty(value = "消息类型")
    @TableField("message_type")
    private String messageType;

    @ApiModelProperty(value = "消息类型（0：群发，1：单独发送）")
    private Integer type;

    @ApiModelProperty(value = "0：有效   1：无效")
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSendUser() {
        return sendUser;
    }

    public void setSendUser(Integer sendUser) {
        this.sendUser = sendUser;
    }

    public Integer getReciverUser() {
        return reciverUser;
    }

    public void setReciverUser(Integer reciverUser) {
        this.reciverUser = reciverUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
        ", id=" + id +
        ", message=" + message +
        ", sendUser=" + sendUser +
        ", reciverUser=" + reciverUser +
        ", createDate=" + createDate +
        ", messageType=" + messageType +
        ", type=" + type +
        ", status=" + status +
        "}";
    }
}
