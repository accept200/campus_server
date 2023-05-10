package com.example.campus_server;

import com.example.campus_server.controller.UserController;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(value = "com.example.campus_server.mapper")
class CampusServerApplicationControllerTests {

    public final Logger logger = LoggerFactory.getLogger(CampusServerApplicationControllerTests.class);
    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
    }





    @Test
    void signupTest() {

    }



}
