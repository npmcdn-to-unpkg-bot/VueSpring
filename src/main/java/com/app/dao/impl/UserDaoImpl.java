package com.app.dao.impl;

import com.app.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import com.app.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mosl on 16/8/29.
 */
@Component
public class UserDaoImpl implements UserDao{

    private String selectUserSql = "select * from user where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(User user){

        String sql = "insert into person values(?,?)";
        return jdbcTemplate.update(sql,user.getName(),user.getPassword()) > 0;
    }

    public boolean delete(User user) {
        return false;
    }

    public boolean update(User user) {
        return false;
    }

    public User get(String uid){
        final User user = new User();
        jdbcTemplate.query(selectUserSql,new Object[]{uid}, new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                user.setId(String.valueOf(rs.getInt("id")));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        });
        return user;
    }

    public boolean update(String uid,String filed,Object value){
        String sql = "update user set " + filed + " =? where id = ?";
        int count = jdbcTemplate.update(sql,new Object[]{value,uid});
        return count > 0;
    }

    public boolean updatePassword(String uid, String password) {
        return false;
    }

    public boolean updateName(String uid, String name) {
        return false;
    }

    public boolean updateNick(String uid, String nick) {
        return false;
    }

}
