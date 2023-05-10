package com.example.campus_server;

import com.example.campus_server.data.LoginRet;
import com.example.campus_server.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
@MapperScan(value = "com.example.campus_server.mapper")
public class CampusServerApplicationServiceTests {
    private final Logger logger = LoggerFactory.getLogger(CampusServerApplicationServiceTests.class);
    @Autowired
    private UserService userService;

    @Test
    void loginTest() {
        String username = "zhangsan@abc.com";
        String password = DigestUtils.md5DigestAsHex("123456".getBytes()).toUpperCase();
        LoginRet ret = userService.login(username, password);
        Assertions.assertEquals(ret.ret, 0);
        Assertions.assertEquals(ret.uid, 1);
        password = DigestUtils.md5DigestAsHex("1234567".getBytes()).toUpperCase();
        ret = userService.login(username, password);
        Assertions.assertEquals(ret.ret, 2);
        username = "zhangsi@abc.com";
        ret = userService.login(username, password);
        Assertions.assertEquals(ret.ret, 1);
        //logger.warn("RET: " + ret.toString());
        //Result result = userController;
    }

    @Test
    void signupTest() {
        String username = "xiaoming@abc.com";
        String nickname = "小明";
        String password = DigestUtils.md5DigestAsHex("654321".getBytes()).toUpperCase();
        int ret = userService.signup(username, password, null);
        Assertions.assertEquals(2, ret);
        ret = userService.signup(username, password, nickname);
        Assertions.assertEquals(0, ret);
        ret = userService.signup(username, password, nickname);
        Assertions.assertEquals(1, ret);
    }
}
