package com.fleebug.config;

import java.time.Duration;

import io.github.cdimascio.dotenv.Dotenv;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {

    public static JedisPool jedisPool;
    public static Dotenv dotenv = Dotenv.load();

    static {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(20); // Maximum total connections
        jedisPoolConfig.setMaxIdle(10); // Maximum idle connections
        jedisPoolConfig.setMinIdle(5); // Minimum idle connections
        jedisPoolConfig.setTestWhileIdle(true); // Test connections during eviction
        jedisPoolConfig.setMinEvictableIdleDuration(Duration.ofMinutes(5)); // Idle >5 min can be evicted
        jedisPoolConfig.setTimeBetweenEvictionRuns(Duration.ofMinutes(1)); // Eviction thread runs every 1 min

        String redisHostName = dotenv.get("REDIS_HOST");
        String redisPassword = dotenv.get("REDIS_PASSWORD");
        String redisPortStr = dotenv.get("REDIS_PORT");

      
        int redisPort = Integer.parseInt(redisPortStr);

        jedisPool = new JedisPool(jedisPoolConfig, redisHostName, (redisPort), 2000, redisPassword);

    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

}
