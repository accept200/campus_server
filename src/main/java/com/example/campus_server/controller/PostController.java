package com.example.campus_server.controller;

import com.example.campus_server.data.NewPost;
import com.example.campus_server.entity.Post;
import com.example.campus_server.entity.PostDetail;
import com.example.campus_server.entity.Tag;
import com.example.campus_server.service.PostService;
import com.example.campus_server.service.RedisService;
import com.example.campus_server.utils.Result;
import com.example.campus_server.utils.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "allPost")
    public Result getAllPost() {
        List<Post> posts = postService.getAllPost();
        return ResultFactory.getSuccessResult("成功", posts);
    }

    @RequestMapping(value = "post")
    public Result getPostById(int post_id) {
        PostDetail postDetail = postService.getPostById(post_id);
        if (postDetail == null) {
            return ResultFactory.getErrorResult("帖子不存在");
        } else {
            return ResultFactory.getSuccessResult("成功", postDetail);
        }
    }

    @RequestMapping(value = "newPost")
    public Result addPost(@RequestHeader Map<String, String> header, NewPost post) {
        int uid = Integer.parseInt(header.get("uid"));
        postService.addPost(uid, post);
        return ResultFactory.getSuccessResult("成功");
    }

    @RequestMapping(value = "deletePost")
    public Result deletePost(@RequestHeader Map<String, String> header, int post_id) {
        int uid = Integer.parseInt(header.get("uid"));
        char priv = redisService.getUserPrivilege(uid);
        if (priv == 'A') {
            postService.deletePost(post_id);
        } else {
            int author_id = postService.getPostById(post_id).getAuthor_id();
            if (author_id == uid) {
                postService.deletePost(post_id);
                return ResultFactory.getSuccessResult("删除成功");
            } else {
                return ResultFactory.getErrorResult("无权限");
            }
        }
        return null;
    }

    @RequestMapping(value = "search")
    public Result searchPostByTitle(String query) {
        List<Post> posts = postService.searchPostInTitle("'&" + query + "%'");
        return ResultFactory.getSuccessResult("成功", posts);
    }

    @RequestMapping(value = "searchTag")
    public Result getPostByTag(int tag_id) {
        List<Post> posts = postService.getPostByTag(tag_id);
        if (posts == null) {
            return ResultFactory.getErrorResult("Tag不存在");
        } else {
            return ResultFactory.getSuccessResult("成功", posts);
        }
    }

    @RequestMapping(value = "tag")
    public Result getAllTag() {
        List<Tag> tags = postService.getAllTag();
        return ResultFactory.getSuccessResult("成功", tags);
    }
}
