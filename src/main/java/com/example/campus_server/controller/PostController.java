package com.example.campus_server.controller;

import com.example.campus_server.data.NewPost;
import com.example.campus_server.utils.Result;
import com.example.campus_server.utils.ResultFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    @RequestMapping(value = "allPost")
    public Result getAllPost() {
        Result<Object> result = ResultFactory.getSuccessResult("SUCCESS");
        return result;
    }

    @RequestMapping(value = "post")
    Result getPostById(int post_id) {
        return null;
    }
    @RequestMapping(value = "newPost")
    public Result addPost(NewPost post) {
        return null;
    }

    @RequestMapping(value = "deletePost")
    public Result deletePost(int post_id) {
        return null;
    }

    @RequestMapping(value = "search")
    public Result searchPostByTitle(String query) {
        return null;
    }

    @RequestMapping(value = "searchTag")
    public Result getPostByTag(int tag_id) {
        return null;
    }

    @RequestMapping(value = "tag")
    public Result getTag() {
        return null;
    }
    @RequestMapping(value = "/geterror")
    public Result getError() {
        Result<Object> result = ResultFactory.getErrorResult("ERR111");
        return result;
    }
}
