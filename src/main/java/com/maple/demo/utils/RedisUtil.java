package com.maple.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class RedisUtil {

	@Autowired
	private static JedisPool jedisPool;

	/**
	 * 获取redis实例
	 *
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 释放redis资源
	 *
	 * @param jedis
	 */
	@SuppressWarnings("deprecation")
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

	public static void put(String key, String value, int expire) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		jedis.expire(key, expire);
		RedisUtil.returnResource(jedis);
	}

	public static void put(String key, String value) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set(key, value);
		RedisUtil.returnResource(jedis);
	}

	public static String get(String key) {
		Jedis jedis = RedisUtil.getJedis();
		String result = jedis.get(key);
		RedisUtil.returnResource(jedis);
		return result;
	}

	public static void expire(String key, int seconds) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.expire(key, seconds);
		RedisUtil.returnResource(jedis);
	}

	public static void hmput(String key, Map<String, String> value, int expire) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.hmset(key, value);
		jedis.expire(key, expire);
		RedisUtil.returnResource(jedis);
	}

	public static List<String> hmget(String key, String... fields) {
		Jedis jedis = RedisUtil.getJedis();
		List<String> result = jedis.hmget(key, fields);
		RedisUtil.returnResource(jedis);
		return result;
	}

	public static boolean exists(String key) {
		Jedis jedis = RedisUtil.getJedis();
		boolean result = jedis.exists(key);
		RedisUtil.returnResource(jedis);
		return result;
	}

	public static void remove(String key) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del(key);
		RedisUtil.returnResource(jedis);
	}

	/**
	 * 从jedis数据库中取出所有匹配pattern的key集合
	 *
	 * @param pattern
	 * @return
	 */
	public static Set<String> getAllKeys(String pattern) {
		Jedis jedis = RedisUtil.getJedis();
		Set<String> keys = jedis.keys(pattern);
		RedisUtil.returnResource(jedis);
		return keys;
	}

	/**
	 *
	 * @param key
	 * @param vals
	 */
	public static void putList(String key, String... vals) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del(key);
		jedis.rpush(key, vals);
		RedisUtil.returnResource(jedis);
	}

	/**
	 *
	 * @param key
	 */
	public static List<String> getAllVal(String key) {
		Jedis jedis = RedisUtil.getJedis();
		List<String> vals = jedis.lrange("badWords", 0, -1);
		RedisUtil.returnResource(jedis);
		return vals;
	}

	public static String getTokenKey(long id) {
		String key = "LOGIN_UserToken_WEB" + id;
		return key;
	}

}
