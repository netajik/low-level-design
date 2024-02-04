package com.lld.concurrencyproblems;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Account {
    private String accountId;
    private String password;
    private AccountStatus status;

    abstract boolean resetPassword();
}
