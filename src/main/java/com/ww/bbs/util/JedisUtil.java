package com.ww.bbs.util;

import io.codis.jodis.RoundRobinJedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class JedisUtil {
	@Autowired
	private RoundRobinJedisPool jedisPool;

	public  String hget(String key, String field) {
		Jedis jedis = jedisPool.getResource();
		String value = null;
		try {
			value = jedis.hget(key, field);
			//LOG.info("HGET(key:{}, field:{})\n value:{}", key, field, value);
			return value;
		} catch (Exception e) {
			//LOG.error("key:{} 错误信息: {}", key, e.getMessage());
			return null;
		}
	}
}
