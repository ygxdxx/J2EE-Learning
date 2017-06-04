package com.test.el;

/**
 * Created by wangsongyan on 2017/6/4.
 * email: wangsongyan921@163.com
 */
public class User {

    private String name;
    private double salary;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
