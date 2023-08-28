package com.designpatterns.behavioural.strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy{

    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;
    DebitCardPaymentStrategy(String cardNumber, String expiryDate,String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Payment dome using debit card..!");
    }
}
