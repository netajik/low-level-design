package com.lld.solidprinciples.dip;

public class ShoppingMall {

    private DebitCard debitCard;

    public ShoppingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void doPurchageSomething(long amount){
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(debitCard);
        shoppingMall.doPurchageSomething(500);
        // here debit card and shopping-mall tightly coupled. if user want to use credit
        // card then we have to change the logic and need pass credit card instance to
        // shopping-mall object.
    }
}
