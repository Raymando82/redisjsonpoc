package com.dcsg.redisjsonpoc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@TestConfiguration
@ActiveProfiles("test")
public class RedisTestConfig {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    public RedisTestConfig(@Value("${spring.redis.port}") final int redisPort, @Value("${spring.redis.host}") final String redisHost) {
        this.redisServer = new RedisServer(redisPort);
    }

    @PostConstruct
    public void startRedis() throws IOException {
        redisServer = new RedisServer(redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }
}
