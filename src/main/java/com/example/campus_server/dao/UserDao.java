package com.example.campus_server.dao;

public interface UserDao {
    String helloWord();

    int addUser(String username, String password, String nickname);
}