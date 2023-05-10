package com.example.campus_server.service.impl;

import com.example.campus_server.data.LoginRet;
import com.example.campus_server.entity.User;
import com.example.campus_server.entity.UserDetail;
import com.example.campus_server.mapper.UserMapper;
import com.example.campus_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {

        return userMapper.getAllUser();
    }

    //判断用户是否存在
    @Override
    public boolean isUsernameExist(String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        userMapper.ifUsernameExist(params);
        boolean isExist = (boolean) params.get("ifExist");
        return isExist;
    }

    //用户注册
    @Override
    public int signup(String username, String password, String nickname) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("nickname", nickname);
        params.put("ret", null); // 注意：这里要为输出参数 `ret` 赋初始值为 null
        userMapper.signup(params);
        int ret = (int) params.get("ret");
        //(Integer) result.get("ret");
        return ret;
    }

    @Override
    public LoginRet login(String username, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("ret", null);
        params.put("user_id", null);
        userMapper.login(params);
        LoginRet ret = new LoginRet();
        ret.uid = (int) params.get("user_id");
        ret.ret = (int) params.get("ret");
        return ret;
    }

    @Override
    public UserDetail getUserInfo(int user_id) {
        return userMapper.getUserInfo(user_id);
    }

    @Override
    public int updatePassword(int user_id, String old_password, String new_password) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", user_id);
        params.put("old_password", old_password);
        params.put("new_password", new_password);
        params.put("ret", null);
        userMapper.updatePassword(params);
        int ret = (int) params.get("ret");
        return ret;
    }

    @Override
    public int updateUserInfo(int user_id, String nickname, String user_info) {
        return 0;
    }


}
