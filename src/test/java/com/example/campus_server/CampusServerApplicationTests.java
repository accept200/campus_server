package com.example.campus_server;

import com.example.campus_server.controller.UserController;
import com.example.campus_server.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CampusServerApplicationTests {

    @Autowired
    UserController userController;
    @Test
    void contextLoads() {
    }

    @Test
    void loginTest() {
        String username = "";
        String password = "";
        //Result result = userController;
    }



}
