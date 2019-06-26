package com.maple.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maple.demo.config.GlobalConfigs;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 获取天气预报
 */
@Component
public class WeatherUtil {

    @Autowired
    private RestTemplate restTemplate;
    private static final String weather = "WEATHER_";

    public List<Map<String, Object>> getWeather(List<String> code){
        List<Map<String, Object>> list = new ArrayList<>();
        for (String codeFlag: code) {

            Map<String, Object> redisReult = RedisUtil.getMap(weather+codeFlag);
            if(redisReult == null){
                Map<String, Object> map = new HashMap<>();
                //获取7天天气信息
                String url = "http://t.weather.sojson.com/api/weather/city/"+codeFlag;
                ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
                map.put("day", JSON.parse(result.getBody()));
                map.put("hour", "小时天气预报");
                list.add(map);
                RedisUtil.putMap(weather+codeFlag, map, GlobalConfigs.WEATHER_CACHE_TIME);
            }else{
                list.add(redisReult);
            }
        }
        return list;
    }

    //爬虫中国天气网小时天气
    public String getWeatherHour(String code){
        String url = "https://tianqi.so.com/weather/"+code;
        Document document = CSDNCrawlerUtils.getUrl(url);
        return null;
    }

}
