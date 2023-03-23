package com.example.campus_server.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int user_id;
    private String nickname;

    public User(int user_id, String nickname) {
        this.user_id = user_id;
        this.nickname = nickname;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
