package com.example.campus_server.dao.impl;

import com.example.campus_server.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Types;

@Repository(value = "UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String helloWord() {
        return null;
    }

    @Override
    public int addUser(String username, String password, String nickname) {
        String sql = """
                EXECUTE [campus].[signup] ?, ?, ?, ? GO
                """;
        return 0;
    }
}
