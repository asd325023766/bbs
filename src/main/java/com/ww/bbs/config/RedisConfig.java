package com.ww.bbs.config;

import io.codis.jodis.RoundRobinJedisPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

	//连接池最大连接数（使用负值表示没有限制）,默认为8
	@Value("${redis.pool.maxActive}")
	private int maxActive;
	//连接池中的最大空闲连接，默认值也是8
	@Value("${redis.pool.maxIdle}")
	private int maxIdle;
	//连接池中的最小空闲连接
	@Value("${redis.pool.minIdle}")
	private int minIdle;
	//连接池最大阻塞等待时间（使用负值表示没有限制）
	@Value("${redis.pool.maxWaitMillis}")
	private int maxWaitMillis;
	//连接超时时间（毫秒）
	@Value("${redis.timeout}")
	private int timeout;
	//redis地址
	@Value("${redis.zkAddr}")
	private String zkAddr;
	@Value("${redis.zkProxyDir}")
	private String zkProxyDir;
	//redis连接密码
	@Value("${redis.encipherpro}")
	private String encipherpro;

	@Bean
	public RoundRobinJedisPool jedisPool() {
		RoundRobinJedisPool	jedisPool = RoundRobinJedisPool.create()
				.password(encipherpro)
				.curatorClient(zkAddr, timeout)
				.zkProxyDir(zkProxyDir)
				.build();
		return jedisPool;
	}
}
