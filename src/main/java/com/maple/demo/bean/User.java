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
 * @since 2019-05-03
 */
@Getter
@Setter
@ToString
@TableName("maple_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 密码
     */
	@TableField("pass_word")
	private String passWord;
    /**
     * 手机号
     */
	private String phone;
    /**
     * 是否绑定邮箱(0：否；1：是）
     */
	@TableField("email_status")
	private Integer emailStatus;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 是否绑定QQ（0：否；1：是）
     */
	@TableField("qq_status")
	private Integer qqStatus;
    /**
     * QQ链接
     */
	@TableField("qq_link")
	private String qqLink;
    /**
     * 是否绑定微信（0：否； 1：是）
     */
	@TableField("wx_status")
	private Integer wxStatus;
    /**
     * 微信链接
     */
	@TableField("wx_link")
	private String wxLink;
	@TableField("create_date")
	private Date createDate;
	@TableField("modify_date")
	private Date modifyDate;
    /**
     * 是否删除
     */
	@TableField("is_delete")
	private Integer isDelete;
    /**
     * 是否锁定
     */
	@TableField("is_lock")
	private Integer isLock;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
