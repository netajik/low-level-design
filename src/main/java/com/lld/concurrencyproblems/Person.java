package com.lld.concurrencyproblems;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    
    private String name;
    private Address address;
    private String email;
    private String phoneNumber;
}   
