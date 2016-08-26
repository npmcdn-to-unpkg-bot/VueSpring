package com.app.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by mosl on 16/8/26.
 */
@Repository
public class CacheRepo {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> operations;

    @PostConstruct
    public void init() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        operations = redisTemplate.opsForValue();
    }

    public void set(String key, Object value) {
        operations.set(key, value);
    }

    public void set(String key, Object value,long expire) {
        operations.set(key, value,expire);
    }

    public Object get(String key) {
        return operations.get(key);
    }
}
