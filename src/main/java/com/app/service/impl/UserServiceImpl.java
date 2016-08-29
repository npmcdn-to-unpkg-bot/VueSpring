package com.app.service.impl;

import com.app.dao.UserDao;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.User;

/**
 * Created by mosl on 16/8/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void insertUser(User user){

        userDao.insert(user);
    }
}
