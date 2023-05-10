package com.example.campus_server.service;

import com.example.campus_server.entity.Comment;

import java.util.List;

public interface CommentService {
    public Comment getCommentById(int comment_id);

    public List<Comment> getCommentOfPost(int post_id);

    public void addComment(int user_id, int post_id, String comment);

    public void deleteComment(int comment_id);

    public void deleteCommentOfPost(int post_id);
}
