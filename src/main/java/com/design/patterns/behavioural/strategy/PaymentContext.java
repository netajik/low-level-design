package com.design.patterns.behavioural.strategy;

public class PaymentContext {
    private final PaymentStrategy paymentStrategy;

    PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void performPayment(double amount) {
        this.paymentStrategy.pay(amount);
    }
}
