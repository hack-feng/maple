package com.maple.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 基础信息-资源表
 * </p>
 *
 * @author maple
 * @since 2019-07-08
 */
@TableName("maple_resources")
public class Resources extends Model<Resources> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 父级id
     */
	@TableField("parent_id")
	private Integer parentId;
    /**
     * 资源名称
     */
	@TableField("res_name")
	private String resName;
    /**
     * 资源描述
     */
	@TableField("res_desc")
	private String resDesc;
    /**
     * 资源类型 1：菜单，2：权限
     */
	@TableField("res_type")
	private Integer resType;
    /**
     * 图标
     */
	private String icon;
    /**
     * 序号
     */
	@TableField("sort_num")
	private Integer sortNum;
    /**
     * 资源路径
     */
	@TableField("res_url")
	private String resUrl;
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
     * 是否删除
     */
	@TableField("is_delete")
	private Integer isDelete;
    /**
     * 状态（0：正常   1：停用）
     */
	private Integer status;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * 获取 父级id
     */
	public Integer getParentId() {
		return parentId;
	}
    /**
     * 设置 父级id
     */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
    /**
     * 获取 资源名称
     */
	public String getResName() {
		return resName;
	}
    /**
     * 设置 资源名称
     */
	public void setResName(String resName) {
		this.resName = resName;
	}
	
    /**
     * 获取 资源描述
     */
	public String getResDesc() {
		return resDesc;
	}
    /**
     * 设置 资源描述
     */
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}
	
    /**
     * 获取 资源类型 1：菜单，2：权限
     */
	public Integer getResType() {
		return resType;
	}
    /**
     * 设置 资源类型 1：菜单，2：权限
     */
	public void setResType(Integer resType) {
		this.resType = resType;
	}
	
    /**
     * 获取 图标
     */
	public String getIcon() {
		return icon;
	}
    /**
     * 设置 图标
     */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
    /**
     * 获取 序号
     */
	public Integer getSortNum() {
		return sortNum;
	}
    /**
     * 设置 序号
     */
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	
    /**
     * 获取 资源路径
     */
	public String getResUrl() {
		return resUrl;
	}
    /**
     * 设置 资源路径
     */
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
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
     * 获取 是否删除
     */
	public Integer getIsDelete() {
		return isDelete;
	}
    /**
     * 设置 是否删除
     */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
    /**
     * 获取 状态（0：正常   1：停用）
     */
	public Integer getStatus() {
		return status;
	}
    /**
     * 设置 状态（0：正常   1：停用）
     */
	public void setStatus(Integer status) {
		this.status = status;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Resources{" +
			"id=" + id +
			", parentId=" + parentId +
			", resName=" + resName +
			", resDesc=" + resDesc +
			", resType=" + resType +
			", icon=" + icon +
			", sortNum=" + sortNum +
			", resUrl=" + resUrl +
			", createDate=" + createDate +
			", modifyDate=" + modifyDate +
			", isDelete=" + isDelete +
			", status=" + status +
			"}";
	}
}
