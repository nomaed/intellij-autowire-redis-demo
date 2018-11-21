package com.nomaed.debug.redistemplateintellij;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication {
    private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Resource(name = "redisTemplate") // intellij shows an error here
    ValueOperations<String, String> valueOps;

    public DemoApplication(@Value("${testvalue}") Integer testValue) {
        logger.info("Value on load: {}", testValue);
        logger.info("All is good!");
    }
}
