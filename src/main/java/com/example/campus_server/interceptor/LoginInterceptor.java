package com.example.campus_server.interceptor;

import com.example.campus_server.redis.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
//        String token = request.getHeader("token");
//        int uid = request.getIntHeader("uid");
//        if (token == null || token.equals(""))
//            return false;
//        else {
//            int user_id = (int) redisUtil.get(token);
//            return uid == user_id;
//        }
    }
}
