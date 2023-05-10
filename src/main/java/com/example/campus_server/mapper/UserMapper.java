package com.example.campus_server.mapper;
import com.example.campus_server.entity.User;
import com.example.campus_server.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface UserMapper {

    List<User> getAllUser();

    //检查用户是否存在
    void ifUsernameExist(Map<String, Object> params);

    //注册用户
    void signup(Map<String, Object> params);

    //用户登录
    void login(Map<String, Object> params);

    char getUserPrivilege(int user_id);

    UserDetail getUserInfo(int user_id);

    void updatePassword(Map<String, Object> params);

}







