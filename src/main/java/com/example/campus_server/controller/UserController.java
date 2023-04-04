package com.example.campus_server.controller;

import com.example.campus_server.entity.User;
import com.example.campus_server.service.UserService;
import com.example.campus_server.utils.Result;
import com.example.campus_server.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/getalluser")
    public Result getAllUser() {
        List<User> users = userService.getAllUser();
        Result<List<User>> result = ResultFactory.getSuccessResult("Success", users);
        return result;
    }

    @RequestMapping(value = "/ping")
    public Result getPing() {
        Result<Object> result = ResultFactory.getSuccessResult("pong");
        return result;
    }

    @RequestMapping(value = "/signup")
    public Result signup(String username, String password, String nickname) {
        int ret = userService.signup(username, password, nickname);
        switch (ret) {
            case 0:
            case 1:
            case 2:
            case 3:
            default:
        }
        Result<Object> result = ResultFactory.getSuccessResult("success sign in");
        return result;
    }
}
