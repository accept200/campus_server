package com.example.campus_server.service.impl;

import com.example.campus_server.entity.Comment;
import com.example.campus_server.mapper.CommentMapper;
import com.example.campus_server.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CommentService")
public class CommentServiceImpl implements CommentService {
    private final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public Comment getCommentById(int comment_id) {
        return commentMapper.getCommentById(comment_id);
    }

    @Override
    public List<Comment> getCommentOfPost(int post_id) {
        return commentMapper.getCommentOfPost(post_id);
    }

    @Override
    public void addComment(int user_id, int post_id, String comment) {
        commentMapper.addComment(user_id, post_id, comment);
    }

    @Override
    public void deleteComment(int comment_id) {
        commentMapper.deleteComment(comment_id);
    }

    @Override
    public void deleteCommentOfPost(int post_id) {
        commentMapper.deleteCommentOfPost(post_id);
    }
}
