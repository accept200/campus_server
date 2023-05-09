package com.example.campus_server.controller;

import com.example.campus_server.service.CommentService;
import com.example.campus_server.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {
    private final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "getComment")
    public Result getComment(int comment_id) {
        return null;
    }

    @RequestMapping(value = "getCommentOfPost")
    public Result getCommentOfPost(int post_id) {
        return null;
    }
}
