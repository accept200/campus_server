package com.example.campus_server.service.impl;

import com.example.campus_server.mapper.UserMapper;
import com.example.campus_server.entity.User;

import com.example.campus_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    public Integer signup(String username, String password, String nickname) {
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

}
