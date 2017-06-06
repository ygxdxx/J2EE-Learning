package com.test.user.test;

import com.test.user.dao.UserDao;
import com.test.user.entity.User;
import org.junit.jupiter.api.Test;

/**
 * Created by wangsongyan on 2017/6/6.
 * email: wangsongyan921@163.com
 */
public class UserDaoTest {

    @Test
    public void testFindByUsername() {
        UserDao userDao = new UserDao();

    }

    @Test
    public void testAdd() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("小红");
        user.setPassword("123");
        userDao.add(user);
    }
}
