package com.example.campus_server.entity;

import java.io.Serializable;

public class LoginInfo implements Serializable {
    int uid;
    String token;

    public LoginInfo(int uid, String token) {
        this.uid = uid;
        this.token = token;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "uid=" + uid +
                ", token='" + token + '\'' +
                '}';
    }
}
