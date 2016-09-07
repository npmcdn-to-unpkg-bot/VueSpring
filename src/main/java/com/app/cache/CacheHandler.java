package com.app.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Created by jerry on 16/8/26.
 * 缓存类
 */
@Component
public class CacheHandler {

    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 缓存,Key,Value,过期时间
     * @param key
     * @param value
     * @param expire
     */
    public void cache(String key, Object value, long expire){

        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key,value,expire);
    }




}
