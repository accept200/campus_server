package com.example.campus_server.mapper;

import com.example.campus_server.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    public Comment getCommentById(int comment_id);
    public List<Comment> getCommentOfPost(int post_id);
}
