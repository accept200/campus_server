package com.example.campus_server.controller;

import com.example.campus_server.entity.User;
import com.example.campus_server.service.UserService;
import com.example.campus_server.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/ifUserExist")
    public boolean ifUserExist(String username) {
        return userService.isUsernameExist(username);
    }

    @RequestMapping(value = "login")
    public Result login(String username, String password) {
        return null;
    }

    @RequestMapping(value = "signup")
    public Result signup(String username, String password, String nickname) {
        return null;
    }

    @RequestMapping(value = "logout")
    public Result logout(int user_id) {
        return null;
    }

    @RequestMapping(value = "userInfo")
    public Result getUserInfo(int user_id) {
        return null;
    }

    @RequestMapping(value = "updatePassword")
    public Result updatePassword(String old_password, String new_password) {
        return null;
    }

    @RequestMapping(value = "updateUserInfo")
    public Result updateUserInfo(int user_id, String new_nickname, String new_user_info) {
        return null;
    }
}


