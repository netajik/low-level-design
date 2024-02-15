package com.lld.stockbrokersystem;

public class Admin extends Account{
    public boolean blockMember(){ return true;}
    public boolean unblockMember(){ return true;}
    public boolean cancelMembership(){ return true;}
    public boolean resetPassword(){
      return true;
    }
}
