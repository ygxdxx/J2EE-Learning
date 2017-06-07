package com.test.user.entity;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class User {
    private String username;
    private String password;
    private String verifyCode;

    public User() {
    }

    public User(String username, String password, String verifyCode) {
        this.username = username;
        this.password = password;
        this.verifyCode = verifyCode;
    }
}
