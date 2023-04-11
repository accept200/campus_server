package com.example.campus_server.service;

import com.example.campus_server.entity.User;
import com.example.campus_server.entity.UserAuth;

import java.util.List;

public interface UserService {
    //public List<User> getAllUser();




    List<User> getAllUser();
    //用户是否存在
    boolean isUsernameExist(String username);
    //用户注册
    Integer signup(String username, String password, String nickname);
}
