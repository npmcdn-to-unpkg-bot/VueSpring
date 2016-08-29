package com.app.dao.impl;

import com.app.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.app.pojo.User;

/**
 * Created by mosl on 16/8/29.
 */
@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(User user){

        String sql = "insert into person values(?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPassword());
    }
}
