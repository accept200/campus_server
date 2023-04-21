package com.example.campus_server.mapper;

import com.example.campus_server.entity.Post;
import com.example.campus_server.entity.PostDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostMapper {
    public List<Post> getAllPost();
    public PostDetail getPostById(int post_id);
    public List<Post> getPostOfUser(int user_id);
    public List<Post> getPostByTag(int tag_id);
}
