package com.test.user.service;

import com.test.user.dao.DaoFactory;
import com.test.user.dao.UserDao;
import com.test.user.entity.User;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class UserService {

    //factory
    private UserDao userDao = DaoFactory.getUserDao();

    public void register(User user) throws UserException {
        //先进行查找
        User _user = userDao.findUserByName(user.getUsername());
        if (_user != null) {
            //用户非空 已存在 抛出异常
            throw new UserException("用户已经存在");
        } else {
            //用户为空 直接添加
            userDao.addUser(user);
        }
    }

    public User login(User user) throws UserException {
        User _user = userDao.findUserByName(user.getUsername());
        if (_user != null) {
            throw new UserException("用户名不存在");
        }

        if (!_user.getPassword().equals(user.getPassword())) {
            throw new UserException("密码错误");
        }
        return _user;
    }
}

