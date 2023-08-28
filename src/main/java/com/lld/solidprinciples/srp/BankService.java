package com.lld.solidprinciples.srp;

public class BankService {

    //we can separate this logic as bank service
    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }

    //we can separate this logic as loan service
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
    }

    //we can separate this logic as notification service
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }

    //we can keep this logic as separate print service
    public void printPassbook() {
        //update transaction info in passbook
    }
}
