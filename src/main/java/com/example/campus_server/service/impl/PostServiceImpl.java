package com.example.campus_server.service.impl;

import com.example.campus_server.data.NewPost;
import com.example.campus_server.entity.Post;
import com.example.campus_server.entity.PostDetail;
import com.example.campus_server.mapper.CommentMapper;
import com.example.campus_server.mapper.PostMapper;
import com.example.campus_server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "PostService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Post> getAllPost() {
        return postMapper.getAllPost();
    }

    @Override
    public PostDetail getPostById(int post_id) {
        return postMapper.getPostById(post_id);
    }

    @Override
    public List<Post> getPostOfUser(int user_id) {
        return postMapper.getPostOfUser(user_id);
    }

    @Override
    public void addPost(int user_id, NewPost post) {
        postMapper.addPost(user_id, post);
    }

    @Override
    public void deletePost(int post_id) {
        commentMapper.deleteCommentOfPost(post_id);
        postMapper.deletePost(post_id);
    }

    @Override
    public List<Post> getPostByTag(int tag_id) {
        return postMapper.getPostByTag(tag_id);
    }

    @Override
    public void deletePostOfUser(int user_id) {
        List<Post> posts = getPostOfUser(user_id);
        for (Post post : posts) {
            commentMapper.deleteCommentOfPost(post.getPost_id());
        }
        postMapper.deletePostOfUser(user_id);
    }

    @Override
    public List<Post> searchPostInTitle(String keyword) {
        return postMapper.searchPostInTitle(keyword);
    }
}
