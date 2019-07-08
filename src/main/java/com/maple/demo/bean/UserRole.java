package com.maple.demo.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 基础信息-用户和角色关联表
 * </p>
 *
 * @author maple
 * @since 2019-07-08
 */
@TableName("maple_user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 角色id
     */
	@TableField("role_id")
	private Integer roleId;
    /**
     * 创建时间 
     */
	@TableField("create_date")
	private Date createDate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * 获取 用户id
     */
	public Integer getUserId() {
		return userId;
	}
    /**
     * 设置 用户id
     */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
    /**
     * 获取 角色id
     */
	public Integer getRoleId() {
		return roleId;
	}
    /**
     * 设置 角色id
     */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
    /**
     * 获取 创建时间 
     */
	public Date getCreateDate() {
		return createDate;
	}
    /**
     * 设置 创建时间 
     */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserRole{" +
			"id=" + id +
			", userId=" + userId +
			", roleId=" + roleId +
			", createDate=" + createDate +
			"}";
	}
}
