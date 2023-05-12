package com.example.campus_server.interceptor;

import com.example.campus_server.redis.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String uid = request.getHeader("uid");
        logger.warn("token: {} uid: {}", token, uid);
        if (token == null || token.isEmpty() || uid == null || uid.isEmpty())
            return false;
        else {
            int user_id = (int) redisUtil.get(token);
            return Integer.parseInt(uid) == user_id;
        }
    }
}
