package com.example.campus_server.service.impl;

import com.example.campus_server.entity.Comment;
import com.example.campus_server.service.CommentService;
import org.springframework.stereotype.Service;

@Service(value = "CommentService")
public class CommentServiceImpl implements CommentService {
    @Override
    public Comment getCommentById(int comment_id) {
        return null;
    }
}
