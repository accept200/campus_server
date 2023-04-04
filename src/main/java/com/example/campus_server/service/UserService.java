package com.example.campus_server.service;

import com.example.campus_server.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public int signup(String username, String password, String nickname);
}
