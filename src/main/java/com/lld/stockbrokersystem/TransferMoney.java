package com.lld.stockbrokersystem;

// TransferMoney is an abstract class
public abstract class TransferMoney {
    private int id;
    private Date creationDate;
    public int fromAccount;
    private int toAccount;
  
    public abstract boolean initiateTransaction();
  }
  
  public class ElectronicBank extends TransferMoney {
    private String bankName;
    
    public boolean initiateTransaction(){
      // definition
    }
  }
  
  public class Wire extends TransferMoney {
    private int wire;
  
    public boolean initiateTransaction(){
      // definition
    }
  }
  
  public class Check extends TransferMoney {
    private String checkNumber;
  
    public boolean initiateTransaction(){
      // definition
    }
  }
  
  public class DepositMoney {
    private int transactionId;
  
    public boolean initiateTransaction(){
      // definition
    }
  }
  
  public class WithdrawMoney {
    private int transactionId;
  }
