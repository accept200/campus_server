package com.example.campus_server.service.impl;

import com.example.campus_server.redis.RedisUtil;
import com.example.campus_server.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "RedisService")
public class RedisServiceImpl implements RedisService {
    private final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    private final String PRIV_PREFIX = "PP";

    @Override
    public boolean userExist(String uuid) {
        return redisUtil.hasKey(uuid);
    }

    @Override
    public int getUserId(String uuid) {
        return (int) redisUtil.get(uuid);
    }

    @Override
    public String userLogin(int user_id) {
        String uuid = UUID.randomUUID().toString();
        redisUtil.set(uuid, user_id);
        return uuid;
    }

    @Override
    public void userLogout(String uuid) {
        int uid = (int) redisUtil.get(uuid);
        redisUtil.delete(PRIV_PREFIX + uid);
        redisUtil.delete(uuid);
    }

    @Override
    public char getUserPrivilege(int user_id) {
        return (char) redisUtil.get(PRIV_PREFIX + user_id);
    }

    @Override
    public void setUserPrivilege(int user_id, char priv) {
        redisUtil.set(PRIV_PREFIX + user_id, priv);
    }

    @Override
    public void removeUserPrivilege(int user_id) {
        redisUtil.delete(PRIV_PREFIX + user_id);
    }
}
