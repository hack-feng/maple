package com.maple.demo.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2019-06-10
 */
@TableName("maple_message")
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 发送消息内容
     */
	private String message;
    /**
     * 发送人id
     */
	@TableField("send_user")
	private Integer sendUser;
    /**
     * 接收人id
     */
	@TableField("reciver_user")
	private Integer reciverUser;
    /**
     * 发送时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 消息类型
     */
	@TableField("message_type")
	private String messageType;
    /**
     * 消息类型（0：群发，1：单独发送）
     */
	private Integer type;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * 获取 发送消息内容
     */
	public String getMessage() {
		return message;
	}
    /**
     * 设置 发送消息内容
     */
	public void setMessage(String message) {
		this.message = message;
	}
	
    /**
     * 获取 发送人id
     */
	public Integer getSendUser() {
		return sendUser;
	}
    /**
     * 设置 发送人id
     */
	public void setSendUser(Integer sendUser) {
		this.sendUser = sendUser;
	}
	
    /**
     * 获取 接收人id
     */
	public Integer getReciverUser() {
		return reciverUser;
	}
    /**
     * 设置 接收人id
     */
	public void setReciverUser(Integer reciverUser) {
		this.reciverUser = reciverUser;
	}
	
    /**
     * 获取 发送时间
     */
	public Date getCreateDate() {
		return createDate;
	}
    /**
     * 设置 发送时间
     */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * 获取 消息类型
     */
	public String getMessageType() {
		return messageType;
	}
    /**
     * 设置 消息类型
     */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
    /**
     * 获取 消息类型（0：群发，1：单独发送）
     */
	public Integer getType() {
		return type;
	}
    /**
     * 设置 消息类型（0：群发，1：单独发送）
     */
	public void setType(Integer type) {
		this.type = type;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Message{" +
			"id=" + id +
			", message=" + message +
			", sendUser=" + sendUser +
			", reciverUser=" + reciverUser +
			", createDate=" + createDate +
			", messageType=" + messageType +
			", type=" + type +
			"}";
	}
}
