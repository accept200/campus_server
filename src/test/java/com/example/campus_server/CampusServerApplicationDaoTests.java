package com.example.campus_server;

import com.example.campus_server.entity.Post;
import com.example.campus_server.entity.PostDetail;
import com.example.campus_server.entity.Tag;
import com.example.campus_server.mapper.CommentMapper;
import com.example.campus_server.mapper.PostMapper;
import com.example.campus_server.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan(value = "com.example.campus_server.mapper")
public class CampusServerApplicationDaoTests {
    private final Logger logger = LoggerFactory.getLogger(CampusServerApplicationDaoTests.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    CommentMapper commentMapper;

    @Test
    void getPostTest() {
        List<Post> posts = postMapper.getAllPost();
        logger.warn(posts.toString());
    }

    @Test
    void getPostDetailTest() {
        int post_id = 1;
        PostDetail postDetail = postMapper.getPostById(post_id);
        logger.warn(postDetail.toString());
    }

    @Test
    void getTagTest() {
        int tag_id = 114514;
        Tag tag = postMapper.getTagById(tag_id);
        Assertions.assertNull(tag);

    }
}
