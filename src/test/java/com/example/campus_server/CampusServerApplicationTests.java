package com.example.campus_server;

import com.example.campus_server.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@MapperScan(value = "com.example.campus_server.mapper")
class CampusServerApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println("hello");
    }

    @Test
    void addUserTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "testuser@abc.com");
        map.put("password", "5F4DCC3B5AA765D61D8327DEB882CF99");
        map.put("nickname", "测试用户");

        userMapper.addUser(map);
        int ret = (int) map.get("ret");
        System.out.println("RET: " + ret);
    }

}
