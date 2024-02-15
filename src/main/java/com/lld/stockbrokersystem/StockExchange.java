package com.lld.stockbrokersystem;

public class StockExchange {
    // The StockExchange is a singleton class that ensures it will have only one active instance at a time
    private static StockExchange instance = null;
  
    // Created a private constructor to add a restriction (due to Singleton)
    private StockExchange() {}
  
    // Created a static method to access the singleton instance of StockExchange
    public static StockExchange getInstance()
    {
      if(instance == null) {
        instance = new StockExchange();
      }
      return instance;
    }
  
    public boolean placeOrder(Order order){return true;}
  }
