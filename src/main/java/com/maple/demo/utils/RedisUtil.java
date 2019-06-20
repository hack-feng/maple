package com.maple.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
@Component
public final class RedisUtil {

	private static String ADDR;

	private static int PORT;

	private static String AUTH;

	private static int MAX_ACTIVE;

	private static int MAX_IDLE;

	private static int MIN_IDLE;

	private static int MAX_WAIT;

	private static int TIMEOUT;
	private static boolean TEST_ON_BORROW = true;
	private static JedisPool jedisPool = null;

	@Value("${spring.redis.host}")
	public static void setADDR(String ADDR) {
		System.out.println("---------------------------------------------------"+ADDR);
		RedisUtil.ADDR = ADDR;
	}
	@Value("${spring.redis.port}")
	public static void setPORT(int PORT) {
		RedisUtil.PORT = PORT;
	}
	@Value("${spring.redis.password}")
	public static void setAUTH(String AUTH) {
		RedisUtil.AUTH = AUTH;
	}
	@Value("${spring.redis.pool.maxActive}")
	public static void setMaxActive(int maxActive) {
		RedisUtil.MAX_ACTIVE = maxActive;
	}
	@Value("${spring.redis.pool.maxIdle}")
	public static void setMaxIdle(int maxIdle) {
		RedisUtil.MAX_IDLE = maxIdle;
	}
	@Value("${spring.redis.pool.minIdle}")
	public static void setMinIdle(int minIdle) {
		RedisUtil.MIN_IDLE = minIdle;
	}
	@Value("${spring.redis.pool.maxWait}")
	public static void setMaxWait(int maxWait) {
		RedisUtil.MAX_WAIT = maxWait;
	}
	@Value("${spring.redis.timeout}")
	public static void setTIMEOUT(int TIMEOUT) {
		RedisUtil.TIMEOUT = TIMEOUT;
	}

	/**
	 * 初始化连接池
	 */
	static {
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			inputStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("application-dev.properties");
			prop.load(inputStream);
			ADDR = prop.getProperty("spring.redis.host");
			PORT = Integer.valueOf(prop.getProperty("spring.redis.port"));
			AUTH = prop.getProperty("spring.redis.password");
			MAX_ACTIVE = Integer.valueOf(prop.getProperty("spring.redis.pool.maxActive"));
			MAX_IDLE = Integer.valueOf(prop.getProperty("spring.redis.pool.maxIdle"));
			MIN_IDLE = Integer.valueOf(prop.getProperty("spring.redis.pool.minIdle"));
			MAX_WAIT = Integer.valueOf(prop.getProperty("spring.redis.pool.maxWait"));
			TIMEOUT = Integer.valueOf(prop.getProperty("spring.redis.timeout"));
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMinIdle(MIN_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			if (StringUtils.isEmpty(AUTH)) {
				jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
			} else {
				jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

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
