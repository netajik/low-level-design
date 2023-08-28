package com.lld.solidprinciples.dip.solution;

public class ShoppingMall {

    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void doPurchageSomething(long amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        //DebitCard debitCard = new DebitCard();
        //CreditCard creditCard = new CreditCard();

        BankCard bankCard = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(bankCard);
        shoppingMall.doPurchageSomething(500);
        // here we can use any card. because we are using interface here.
    }
}
