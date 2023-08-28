package com.lld.couponmanagement.entity;

public class Person {

    Integer id;
    String name;
    String password;

    Person(Integer userId, String userName, String password) {
        this.id = userId;
        this.name = userName;
        this.password = password;
    }
}
