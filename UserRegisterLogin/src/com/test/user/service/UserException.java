package com.test.user.service;

/**
 * Created by wangsongyan on 2017/6/6.
 * email: wangsongyan921@163.com
 */
public class UserException extends Exception {

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

}
