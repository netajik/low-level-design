package com.lld.vendingmachine.problem1.model;

public class CardPayment implements Payment{
    @Override
    public float checkout(float amount) {
        return amount;
    }
}
