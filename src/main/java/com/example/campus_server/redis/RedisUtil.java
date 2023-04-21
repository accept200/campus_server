package com.example.campus_server.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean expire(String key, long time_s) {
        if (time_s > 0) {
            redisTemplate.expire(key, time_s, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, long time_s) {
        redisTemplate.opsForValue().set(key, value, time_s, TimeUnit.SECONDS);
    }

    public Map<Object, Object> getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public void setMap(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public void deleteMap(String key) {
        redisTemplate.opsForHash().delete(key);
    }

    public Object getMapValue(String key, String mapKey) {
        return redisTemplate.opsForHash().get(key, mapKey);
    }

    public void setMapKey(String key, String mapKey, Object value) {
        redisTemplate.opsForHash().put(key, mapKey, value);
    }

    public void deleteMapKey(String key, String mapKey) {
        redisTemplate.opsForHash().delete(key, mapKey);
    }
}
