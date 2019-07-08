package com.maple.demo.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 基础信息-角色和资源关联表
 * </p>
 *
 * @author maple
 * @since 2019-07-08
 */
@TableName("maple_role_res")
public class RoleRes extends Model<RoleRes> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色id
     */
	@TableField("role_id")
	private Integer roleId;
    /**
     * 资源id
     */
	@TableField("res_id")
	private Integer resId;
	@TableField("create_date")
	private Date createDate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
     * 获取 资源id
     */
	public Integer getResId() {
		return resId;
	}
    /**
     * 设置 资源id
     */
	public void setResId(Integer resId) {
		this.resId = resId;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RoleRes{" +
			"id=" + id +
			", roleId=" + roleId +
			", resId=" + resId +
			", createDate=" + createDate +
			"}";
	}
}
