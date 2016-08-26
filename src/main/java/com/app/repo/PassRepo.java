package com.app.repo;

import com.app.pojo.Pass;
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
public class PassRepo {

    @Autowired
    private RedisTemplate<String, Pass> redisTemplate;

    private ValueOperations<String, Pass> operations;

    @PostConstruct
    public void init() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Pass>(Pass.class));
        operations = redisTemplate.opsForValue();
    }

    public void set(String key, Pass value) {
        operations.set(key, value);
    }

    public void set(String key, Pass value,long time) {
        operations.set(key, value,time);
    }

    public Pass get(String key) {
        return operations.get(key);
    }
}
