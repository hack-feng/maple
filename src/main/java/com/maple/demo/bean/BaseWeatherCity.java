package com.maple.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 基础信息-天气城市表
 * </p>
 *
 * @author maple
 * @since 2019-07-09
 */
@TableName("base_weather_city")
@ApiModel(value="BaseWeatherCity对象", description="基础信息-天气城市表")
public class BaseWeatherCity extends Model<BaseWeatherCity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "城市id")
    @TableField("city_id")
    private String cityId;

    @ApiModelProperty(value = "城市名称")
    @TableField("city_name")
    private String cityName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BaseWeatherCity{" +
        ", id=" + id +
        ", cityId=" + cityId +
        ", cityName=" + cityName +
        "}";
    }
}
