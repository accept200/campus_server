package com.example.campus_server.service.impl;

import com.example.campus_server.redis.RedisUtil;
import com.example.campus_server.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisServiceImpl implements RedisService {
    private final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean userExist(String uuid) {
        return redisUtil.hasKey(uuid);
    }

    @Override
    public int getUserId(String uuid) {
        return 0;
    }

    @Override
    public String userLogin(int user_id) {
        return null;
    }

    @Override
    public void userLogout(String uuid) {

    }

    @Override
    public int getUserPrivilege(int user_id) {
        return 0;
    }

    @Override
    public void setUserPrivilege(int user_id, int priv) {

    }

    @Override
    public void removeUserPrivilege(int user_id) {

    }
}
