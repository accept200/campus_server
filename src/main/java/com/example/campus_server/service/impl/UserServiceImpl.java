package com.example.campus_server.service.impl;

import com.example.campus_server.entity.User;
import com.example.campus_server.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUser() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Tom", 25));
        users.add(new User("John", 30));
        return users;
    }
}
