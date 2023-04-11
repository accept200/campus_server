package com.example.campus_server.controller;

import com.example.campus_server.redis.RedisUtil;
import com.example.campus_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected UserService userService;

    @Autowired
    protected RedisUtil redisUtil;
}
