package com.example.campus_server.service;

import com.example.campus_server.data.NewPost;
import com.example.campus_server.entity.Post;
import com.example.campus_server.entity.PostDetail;
import com.example.campus_server.entity.Tag;

import java.util.List;

public interface PostService {
    public List<Post> getAllPost();
    public PostDetail getPostById(int post_id);
    public List<Post> getPostOfUser(int user_id);
    public void addPost(int user_id, NewPost post);
    public void deletePost(int post_id);
    public List<Post> getPostByTag(int tag_id);
    public void deletePostOfUser(int user_id);
    public List<Post> searchPostInTitle(String keyword);
    public List<Tag> getAllTag();
}
