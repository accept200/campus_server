package com.example.campus_server.mapper;
import com.example.campus_server.entity.User;
import com.example.campus_server.entity.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface UserMapper {
    //@Select("SELECT user_id, nickname FROM [campus].[user]")
    List<User> getAllUser();

        //检查用户是否存在

            //@Select(value = "{CALL if_username_exist(#{username, mode=IN, jdbcType=NVARCHAR}, #{ifExist, mode=OUT, jdbcType=BIT})}")
    void ifUsernameExist(Map<String, Object> params);



    //注册用户



   // @Options(statementType = StatementType.CALLABLE)
//   @Select("{CALL [campus].[signup](" +
//           "#{username, mode=IN, jdbcType=NVARCHAR}," +
//           "#{password, mode=IN, jdbcType=CHAR}," +
//           "#{nickname, mode=IN, jdbcType=NVARCHAR}," +
//           "#{ret, mode=OUT, jdbcType=INTEGER}" +
//           ")}")
   int signup(Map<String, Object> params);





}







