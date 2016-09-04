package com.app.service;

import com.app.exception.UserNotFoundException;
import com.app.pojo.User;

/**
 * Created by mosl on 16/8/25.
 */
public interface UserService {

    void insert(User user);

    User find(int uid) throws UserNotFoundException;

    User find(String uid);

    boolean update(int uid,String field,Object value);
}
