package com.example.campus_server.service.impl;

import com.example.campus_server.dao.UserDao;
import com.example.campus_server.entity.User;
import com.example.campus_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUser() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"Tom"));
        users.add(new User(2,"John"));
        return users;
    }

    @Override
    public int signup(String username, String password, String nickname) {
        int ret = userDao.addUser(username, password, nickname);
        return ret;
    }
}
