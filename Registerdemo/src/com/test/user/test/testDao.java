package com.test.user.test;

import com.test.user.dao.UserDao;
import com.test.user.entity.User;
import org.junit.jupiter.api.Test;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class testDao {

    @Test
    public void testFind() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.findUserByName("小明"));
    }

    @Test
    public void testAdd() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setPassword("123456");
        user.setUsername("小明");
        userDao.addUser(user);
    }
}
