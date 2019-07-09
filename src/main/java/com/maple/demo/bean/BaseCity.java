package com.maple.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@TableName("base_city")
@ApiModel(value="BaseCity对象", description="")
public class BaseCity extends Model<BaseCity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "城市名称")
    @TableField("city_name")
    private String cityName;

    @ApiModelProperty(value = "城市编码")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty(value = "上级id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "老的城市名称")
    @TableField("city_name_old")
    private String cityNameOld;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCityNameOld() {
        return cityNameOld;
    }

    public void setCityNameOld(String cityNameOld) {
        this.cityNameOld = cityNameOld;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BaseCity{" +
        ", id=" + id +
        ", cityName=" + cityName +
        ", cityCode=" + cityCode +
        ", parentId=" + parentId +
        ", cityNameOld=" + cityNameOld +
        "}";
    }
}
