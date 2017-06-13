package com.test.user.test;

import com.test.user.dao.UserDaoImp;
import com.test.user.entity.User;
import com.test.user.util.CommonUtils;
import org.junit.jupiter.api.Test;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class testDao {

    @Test
    public void testFind() {
        UserDaoImp userDaoImp = new UserDaoImp();
        System.out.println(userDaoImp.findUserByName("小明"));
    }

    @Test
    public void testAdd() {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User();
        user.setPassword("123456");
        user.setUsername("小明");
        userDaoImp.addUser(user);
    }

    @Test
    public void testUUID(){
        System.out.println(CommonUtils.getUUID());
    }
}
