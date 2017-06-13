package com.test.user.dao;

import com.test.user.entity.User;

/**
 * Created by wangsongyan on 2017/6/13.
 * email: wangsongyan921@163.com
 */
public interface UserDao {

    public User findUserByName(String username);

    public void addUser(User user);
}
