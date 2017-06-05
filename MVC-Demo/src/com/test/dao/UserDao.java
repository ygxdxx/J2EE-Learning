package com.test.dao;

import com.test.domain.User;

/**
 * Created by wangsongyan on 2017/6/5.
 * email: wangsongyan921@163.com
 */
public class UserDao {

    public User find(){
        return new User("小明",18);
    }

}
