package com.example.campus_server;

import com.example.campus_server.controller.UserController;
import com.example.campus_server.entity.Post;
import com.example.campus_server.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CampusServerApplicationTests {

    public final Logger logger = LoggerFactory.getLogger(CampusServerApplicationTests.class);
    @Autowired
    UserController userController;
    @Autowired
    PostMapper postMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void loginTest() {
        String username = "";
        String password = "";
        //Result result = userController;
    }

    @Test
    void getPostTest() {

        List<Post> posts = postMapper.getAllPost();
        logger.warn(posts.toString());
    }



}
