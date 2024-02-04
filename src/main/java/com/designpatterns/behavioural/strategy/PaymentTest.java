package com.design.patterns.behavioural.strategy;

public class PaymentTest {

    public static void main(String args[]){
        boolean usingUpi = false;
        if(usingUpi) {
            PaymentStrategy paymentStrategy
                    = new UpiPaymentStrategy("12345@upi", "12345");
            PaymentContext paymentContext = new PaymentContext(paymentStrategy);
            paymentContext.performPayment(100d);
        } else {
            PaymentStrategy paymentStrategy1
                    = new DebitCardPaymentStrategy("1234 1234 1234","12/12/2034","123");
            PaymentContext paymentContext1 = new PaymentContext(paymentStrategy1);
            paymentContext1.performPayment(100d);
        }
    }
}