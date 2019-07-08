package com.maple.demo.bean;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>
 * 基础信息-用户角色表
 * </p>
 *
 * @author maple
 * @since 2019-07-08
 */
@TableName("maple_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 修改时间
     */
	@TableField("modify_date")
	private Date modifyDate;
    /**
     * 是否删除（0：否 1：是）
     */
	@TableField("is_delete")
	private Integer isDelete;
    /**
     * 是否启用（0：正常， 1：停用）
     */
	private Integer status;
    /**
     * 备注
     */
	private String remark;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * 获取 角色名称
     */
	public String getRoleName() {
		return roleName;
	}
    /**
     * 设置 角色名称
     */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	
    /**
     * 获取 修改时间
     */
	public Date getModifyDate() {
		return modifyDate;
	}
    /**
     * 设置 修改时间
     */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
    /**
     * 获取 是否删除（0：否 1：是）
     */
	public Integer getIsDelete() {
		return isDelete;
	}
    /**
     * 设置 是否删除（0：否 1：是）
     */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
    /**
     * 获取 是否启用（0：正常， 1：停用）
     */
	public Integer getStatus() {
		return status;
	}
    /**
     * 设置 是否启用（0：正常， 1：停用）
     */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
    /**
     * 获取 备注
     */
	public String getRemark() {
		return remark;
	}
    /**
     * 设置 备注
     */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			"id=" + id +
			", roleName=" + roleName +
			", createDate=" + createDate +
			", modifyDate=" + modifyDate +
			", isDelete=" + isDelete +
			", status=" + status +
			", remark=" + remark +
			"}";
	}
}
