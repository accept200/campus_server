package com.example.campus_server.entity;

public class UserDetail extends User{
    private String user_info;

    public UserDetail(int user_id, String nickname, String user_info) {
        super(user_id, nickname);
        this.user_info = user_info;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }
}
