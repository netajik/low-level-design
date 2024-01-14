package com.design.patterns.creational.singleton;

public class EnumSingletonTest {

    public static void main(String[] args) {
    	EnumSingleton instance =  EnumSingleton.INSTANCE;
    	System.out.println(instance.getName());
    	instance.setName("Netaji");
    	System.out.println(instance.getName());
    }
}
