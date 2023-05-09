package com.example.campus_server.service;

public interface RedisService {
    public boolean userExist(String uuid);
    public int getUserId(String uuid);
    public String userLogin(int user_id);
    public void userLogout(String uuid);
    public int getUserPrivilege(int user_id);
    public void setUserPrivilege(int user_id, int priv);
    public void removeUserPrivilege(int user_id);
}
