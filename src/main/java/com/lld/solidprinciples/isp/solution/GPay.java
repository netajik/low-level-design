package com.lld.solidprinciples.isp.solution;

public class GPay implements UPIPayments,CashBackManager {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {
        //supported
    }
}
