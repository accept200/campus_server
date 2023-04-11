package com.example.campus_server.controller;

import com.example.campus_server.entity.User;
import com.example.campus_server.entity.UserAuth;
import com.example.campus_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends BaseController {

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



}


