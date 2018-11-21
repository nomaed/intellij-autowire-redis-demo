package com.nomaed.debug.redistemplateintellij;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisExample {
    private final static Logger logger = LoggerFactory.getLogger(RedisExample.class);

    @Resource(name = "redisTemplate")
    ValueOperations<String, String> valueOps;

    public RedisExample(@Value("${testvalue}") Integer testValue) {
        logger.info("Value on load: {}", testValue);
        logger.info("redisTemplate valueOps: {}", valueOps);
        logger.info("All is good!");
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        StringRedisSerializer serializer = new StringRedisSerializer();
        template.setKeySerializer(serializer);
        template.setHashKeySerializer(serializer);
        template.setHashValueSerializer(serializer);
        template.setValueSerializer(serializer);
        return template;
    }

    @Bean
    public Integer killer(@Value("${testvalue}") Integer testValue,
                          JedisConnectionFactory jedisConnectionFactory) {
        // destroying connection so process will exit
        jedisConnectionFactory.destroy();
        return testValue;
    }

}
