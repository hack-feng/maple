package com.maple.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maple.demo.config.GlobalConfigs;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
            getWeatherHour(codeFlag);
        }
        return list;
    }

    //爬虫中国天气网小时天气
    public String getWeatherHour(String code){
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> today = new HashMap<>();
        Map<String, Object> tomorrow = new HashMap<>();

        String url = "https://tianqi.so.com/weather/"+code;
        Document document = CSDNCrawlerUtils.getUrl(url);


        Element element = document.getElementsByClass("content-inner-left").get(0).getElementsByClass("tabs-content").get(0);

        // 今天的天气页面
        Element todayEl = element.getElementsByClass("weather-today").get(0);
        today = getContent(todayEl, "todayHoursValue");
        // 明天的天气页面
        Element tomorrowEl = element.getElementsByClass("weather-tomorrow").get(0);
        tomorrow = getContent(tomorrowEl, "tomorrowHoursValue");

        map.put("today",today);
        map.put("tomorrow",tomorrow);
        String a = document.getElementsByTag("script").get(0).toString();
        System.out.println(a);
        return null;
    }

    /** 获取小时天气处理方法 **/
    public Map<String, Object> getContent(Element elementFlag, String day){
        Map<String, Object> resultMap = new HashMap<>();

        //获取天气详情信息
        String content = elementFlag.getElementsByClass("cur-weather").get(0).toString();
        //获取小时
        Elements hourEl = elementFlag.getElementsByClass("curve-info-wrap").get(0).getElementsByClass("curve-info-item");
        //获取小时风向
        Elements windEl = elementFlag.getElementsByClass("curve-info-wrap").get(1).getElementsByClass("curve-info-item");

        // 存放小时的数组
        String[] hourArray = new String[hourEl.size()];
        // 存放天气情况
        String[] weatherArray = new String[hourEl.size()];
        // 存放风向的数组
        String[] windArray = new String[hourEl.size()];

        // 存放风力的数组
        String[] windPowerArray = new String[hourEl.size()];
        // 存放空气质量的数组
        String[] kqzlArray = new String[hourEl.size()];
        // 存放温度的数组
        String[] temperatureArray = new String[hourEl.size()];
        for (int i = 0; i < hourEl.size(); i ++) {
            hourArray[i] = hourEl.get(i).getElementsByTag("p").get(0).text();
            weatherArray[i] = hourEl.get(i).select("p").get(1).attr("class")
                    .trim().replace("weather-icon","")
                    .replace("\\n","");
            kqzlArray[i] = windEl.get(i).getElementsByTag("p").get(0).text();
            windArray[i] = windEl.get(i).getElementsByTag("p").get(1).text();
            windPowerArray[i] = windEl.get(i).getElementsByTag("p").get(2).text();
        }

        //获取小时温度
        Element scriptEl = elementFlag.getElementsByTag("script").get(0);

        /*取得JS变量数组*/
        String[] data = scriptEl.data().toString().split("var");
        /*取得单个JS变量*/
        for(String variable : data){

            /*过滤variable为空的数据*/
            if(variable.contains("=")){

                /*取到满足条件的JS变量*/
                if(variable.contains(day)) {

                    String[] kvp = variable.split("=");

                    /*取得JS变量存入map*/
                    if (kvp[0].trim().contains(day)) {
                        String value = kvp[1].trim()
                                .replace("\"","")
                                .replace("\\n","")
                                .replace("[","")
                                .replace("]","");
                        temperatureArray = value.split(",");
                    }
                }
            }
        }

        resultMap.put("content", content);
        resultMap.put("hourArray", hourArray);
        resultMap.put("windArray", windArray);
        resultMap.put("windPowerArray", windPowerArray);
        resultMap.put("kqzlArray", kqzlArray);
        resultMap.put("weatherArray", weatherArray);
        resultMap.put("temperatureArray", temperatureArray);

        return resultMap;
    }

}
