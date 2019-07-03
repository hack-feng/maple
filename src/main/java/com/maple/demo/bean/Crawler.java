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
 * 
 * </p>
 *
 * @author 
 * @since 2019-07-02
 */
@TableName("maple_crawler")
public class Crawler extends Model<Crawler> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 文章标题
     */
	private String title;
    /**
     * 文章内容
     */
	private String content;
    /**
     * 作者
     */
	private String auther;
    /**
     * 文章地址
     */
	private String url;
    /**
     * 阅读量
     */
	private Integer num;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 搜索的关键字
     */
	@TableField("search_content")
	private String searchContent;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * 获取 文章标题
     */
	public String getTitle() {
		return title;
	}
    /**
     * 设置 文章标题
     */
	public void setTitle(String title) {
		this.title = title;
	}
	
    /**
     * 获取 文章内容
     */
	public String getContent() {
		return content;
	}
    /**
     * 设置 文章内容
     */
	public void setContent(String content) {
		this.content = content;
	}
	
    /**
     * 获取 作者
     */
	public String getAuther() {
		return auther;
	}
    /**
     * 设置 作者
     */
	public void setAuther(String auther) {
		this.auther = auther;
	}
	
    /**
     * 获取 文章地址
     */
	public String getUrl() {
		return url;
	}
    /**
     * 设置 文章地址
     */
	public void setUrl(String url) {
		this.url = url;
	}
	
    /**
     * 获取 阅读量
     */
	public Integer getNum() {
		return num;
	}
    /**
     * 设置 阅读量
     */
	public void setNum(Integer num) {
		this.num = num;
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
     * 获取 搜索的关键字
     */
	public String getSearchContent() {
		return searchContent;
	}
    /**
     * 设置 搜索的关键字
     */
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Crawler{" +
			"id=" + id +
			", title=" + title +
			", content=" + content +
			", auther=" + auther +
			", url=" + url +
			", num=" + num +
			", createDate=" + createDate +
			", searchContent=" + searchContent +
			"}";
	}
}
