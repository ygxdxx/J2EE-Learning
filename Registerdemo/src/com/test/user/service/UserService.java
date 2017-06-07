package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.entity.User;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public void register(User user){
        User _user = userDao.findUserByName(user.getUsername());

    }
}

