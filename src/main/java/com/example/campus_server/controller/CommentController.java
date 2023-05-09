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

    @RequestMapping(value = "comment")
    public Result getComment(int comment_id) {
        return null;
    }

    @RequestMapping(value = "postComment")
    public Result getCommentOfPost(int post_id) {
        return null;
    }

    @RequestMapping(value = "newComment")
    public Result addComment(int post_id, String comment) {
        return null;
    }

    @RequestMapping(value = "deleteComment")
    public Result deletePost(int post_id) {
        return null;
    }
}
