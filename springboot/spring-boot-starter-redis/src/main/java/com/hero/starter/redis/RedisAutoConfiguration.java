package com.hero.starter.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @description: RedisAutoConfiguration
 * @date: 2020/11/1
 * @author: bear
 * @version: 1.0
 */
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Jedis getJedis(RedisProperties redisProperties) {

        Jedis jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
        jedis.auth(redisProperties.getPassword());
        return jedis;
    }

}
