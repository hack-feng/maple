package com.maple.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

public class BaseController<K, V> {

	@Autowired
	private RedisTemplate<K, V> redisTemplate;
	
	public void valueOperations(K key, V value) {
		ValueOperations<K, V> valueOperations = redisTemplate.opsForValue();//操作字符串
		valueOperations.set(key, value);
	}
	
	public void hashOperations(K key, K hashKey, V value) {
		HashOperations<K, K, V> hashOperations = redisTemplate.opsForHash();//操作hash
		hashOperations.put(key, hashKey, value);
	}
	
	public void listOperations(K key ) {
		ListOperations<?, ?> listOperations = redisTemplate.opsForList();//操作list
	}
	
	public void SetOperations(K key, Set<V> value) {
		SetOperations<?, ?> setOperations = redisTemplate.opsForSet();//操作set
	}
	
	public void zSetOperations() {
		ZSetOperations<?, ?> zSetOperations = redisTemplate.opsForZSet();//操作有序set
	
	}
	
    /**
     * 定义返回类型
     */
    public enum Type {
        success,
        error
    }

    public String message(Type type, String content) {
        return "{\"type\":\"" + (type == Type.success ? "success" : "error") + "\",\"content\":\"" + content + "\"}";
    }

    public String message(Type type, String content, Object... args) {
        for (Object object : args) {
            object.toString();
        }
        return "{\"type\":\"" + (type == Type.success ? "success" : "error") + "\",\"content\":\"" + content + "\"}";
    }

    public Map<String, Object> messageToMap(Type type, Object content) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type == Type.success ? "success" : "error");
        map.put("content", content);
        return map;
    }
}
