package com.lld.stockbrokersystem;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.lld.stockbrokersystem.enums.OrderStatus;
import com.lld.stockbrokersystem.enums.TimeEnforcementType;

public class Member extends Account {
      private double availableFundsForTrading;
  private Date dateOfMembership;
  private HashMap<string, StockPosition> stockPositions;
  private HashMap<Integer, Order> activeOrders;

  public ErrorCode placeSellLimitOrder(string stockId, float quantity, int limitPrice, TimeEnforcementType enforcementType){}
  public ErrorCode placeBuyLimitOrder(string stockId, float quantity, int limitPrice, TimeEnforcementType enforcementType){}
  public void callbackStockExchange(int orderId, List<OrderPart> orderParts, OrderStatus status){}
  public boolean resetPassword(){
    // definition
  }
}
