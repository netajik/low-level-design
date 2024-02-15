package com.lld.stockbrokersystem;

import com.lld.stockbrokersystem.enums.AccountStatus;

public abstract class Account {
    private String id;
    private String password;
    private String name;
    private AccountStatus status;
    private Address address;
    private String email;
    private String phone;
  
    public abstract boolean resetPassword();
}
