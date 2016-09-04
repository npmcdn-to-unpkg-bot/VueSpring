package com.app.service.impl;

import com.app.dao.UserDao;
import com.app.exception.UserNotFoundException;
import com.app.service.UserService;
import org.apache.commons.lang3.StringUtils;
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

    public void insert(User user){
        userDao.insert(user);
    }

    public User find(int uid) throws UserNotFoundException{
        if(uid == 0){
            throw new UserNotFoundException("sdfs");
        }
        return new User();
    }

    public User find(String uid){
        if(StringUtils.isBlank(uid)){
            throw new IllegalArgumentException("uid is blank");
        }
        return userDao.get(uid);
    }

    public boolean update(int uid,String field,Object value){
        return userDao.update(Integer.toString(uid),field,value);
    }
}
