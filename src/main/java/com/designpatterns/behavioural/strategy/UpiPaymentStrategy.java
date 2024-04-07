package com.designpatterns.behavioural.strategy;

public class UpiPaymentStrategy implements PaymentStrategy{

    private final String upiId;
    private final String pin;
    UpiPaymentStrategy(String upiId, String pin) {
        this.upiId = upiId;
        this.pin = pin;
    }
    @Override
    public void pay(double amount) {
     System.out.println("Payment done using upi..!");
    }
}
