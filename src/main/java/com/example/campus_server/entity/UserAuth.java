package com.example.campus_server.entity;

public class UserAuth extends User {
    private String email;
    private String password;

    public UserAuth(int user_id, String nickname, String email, String password) {
        super(user_id, nickname);
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
