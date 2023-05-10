package com.example.campus_server.service;

import com.example.campus_server.data.LoginRet;
import com.example.campus_server.entity.User;
import com.example.campus_server.entity.UserDetail;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    //用户是否存在
    boolean isUsernameExist(String username);
    //用户注册
    int signup(String username, String password, String nickname);
    //用户登录
    LoginRet login(String username, String password);

    UserDetail getUserInfo(int user_id);

    int updatePassword(int user_id, String old_password, String new_password);

    int updateUserInfo(int user_id, String nickname, String user_info);
}
