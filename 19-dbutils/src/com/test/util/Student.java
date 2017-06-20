package com.test.util;

/**
 * Created by wangsongyan on 2017/6/20.
 * email: wangsongyan921@163.com
 */
public class Student {

    private String username;
    private int age;

    public Student() {
    }

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
