package com.example.campus_server.controller;

import com.example.campus_server.utils.Result;
import com.example.campus_server.utils.ResultFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    @RequestMapping(value = "/getallpost")
    public Result getAllPost() {
        Result<Object> result = ResultFactory.getSuccessResult("SUCCESS");
        return result;
    }

    @RequestMapping(value = "/geterror")
    public Result getError() {
        Result<Object> result = ResultFactory.getErrorResult("ERR111");
        return result;
    }
}
