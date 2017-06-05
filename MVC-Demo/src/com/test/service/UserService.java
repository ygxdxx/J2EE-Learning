package com.test.service;

import com.test.dao.UserDao;
import com.test.domain.User;

/**
 * Created by wangsongyan on 2017/6/5.
 * email: wangsongyan921@163.com
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public User find() {
        return userDao.find();
    }
}
