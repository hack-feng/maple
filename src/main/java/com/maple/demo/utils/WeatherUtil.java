package com.maple.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * 获取天气预报
 */
@Component
public class WeatherUtil {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getWeather(List<String> code){
        List<String> list = new ArrayList<>();
        for (String codeFlag: code) {
            String url = "http://t.weather.sojson.com/api/weather/city/"+codeFlag;
            ResponseEntity<String> map = restTemplate.getForEntity(url, String.class);
            String result = map.getBody();
            list.add(result);
        }
        return list;
    }
}
