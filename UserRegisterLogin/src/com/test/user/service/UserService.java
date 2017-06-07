package com.test.user.service;

import com.test.user.dao.UserDao;
import com.test.user.entity.User;
import com.test.user.exception.UserException;

/**
 * Created by wangsongyan on 2017/6/5.
 * email: wangsongyan921@163.com
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public void register(User user) throws UserException {
        User _user = userDao.findUserByName(user.getName());
        if (_user != null) {
            throw new UserException("用户名：" + _user.getName() + "已存在");
        } else {
            userDao.add(user);
        }
    }
}
