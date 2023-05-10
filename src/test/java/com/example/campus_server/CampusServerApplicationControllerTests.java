package com.example.campus_server;

import com.example.campus_server.controller.CommentController;
import com.example.campus_server.controller.PostController;
import com.example.campus_server.controller.UserController;
import com.example.campus_server.entity.LoginInfo;
import com.example.campus_server.utils.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@MapperScan(value = "com.example.campus_server.mapper")
class CampusServerApplicationControllerTests {

    public final Logger logger = LoggerFactory.getLogger(CampusServerApplicationControllerTests.class);
    @Autowired
    UserController userController;
    @Autowired
    PostController postController;
    @Autowired
    CommentController commentController;

    @Test
    void contextLoads() {
    }

    @Test
    void loginTest() {
        String username = "zhangsan@abc.com";
        String password = DigestUtils.md5DigestAsHex("123456".getBytes()).toUpperCase();
        Result<LoginInfo> result = userController.login(username, password);
        Assertions.assertEquals(1, result.getData().getUid());
        logger.warn("UUID: " + result.getData().getToken());
    }

    @Test
    void logoutTest() {
        String uuid = "a06a17e1-3ce1-4ada-ab86-033c0a0f6dab";
        int uid = 1;
        Map<String, String> header = new HashMap<>();
        header.put("token", uuid);
        header.put("uid", String.valueOf(uid));
        Result result = userController.logout(header);
        logger.warn("RET: " + result.getCode() + " " + result.getMessage());
    }

}
