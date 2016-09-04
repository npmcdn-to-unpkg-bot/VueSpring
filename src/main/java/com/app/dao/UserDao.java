package com.app.dao;

import com.app.pojo.User;

/**
 * Created by mosl on 16/8/29.
 */

public interface UserDao extends BaseDao<User>{

    /**
     * 插入用户
     * @param user
     */
    boolean insert(User user);

    /**
     * 获取用户
     * @param uid
     * @return
     */
    User get(String uid);

    /**
     * 更新用户
     * @param uid
     * @param filed
     * @param value
     * @return
     */
    boolean update(String uid,String filed,Object value);

    /**
     * 更新密码
     * @param uid
     * @param password
     * @return
     */
    boolean updatePassword(String uid,String password);

    /**
     * 更新用户名
     * @param uid
     * @param name
     * @return
     */
    boolean updateName(String uid,String name);

    /**
     * 更新昵称
     * @param uid
     * @param nick
     * @return
     */
    boolean updateNick(String uid,String nick);

}
