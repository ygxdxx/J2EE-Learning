package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.entity.User;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public void register(User user) throws UserException {
        User _user = userDao.findUserByName(user.getUsername());
        if (_user != null) {
            //添加失败
            throw new UserException("用户已经存在");
        } else {
            //添加成功
            userDao.addUser(user);
        }
    }
}

