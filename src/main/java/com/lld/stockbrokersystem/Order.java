package com.lld.stockbrokersystem;

import java.util.Date;

import com.lld.stockbrokersystem.enums.OrderStatus;
import com.lld.stockbrokersystem.enums.TimeEnforcementType;

// Order is an abstract class
public abstract class Order {
    private String orderNumber;
    public boolean isBuyOrder;
    private OrderStatus status;
    private TimeEnforcementType timeEnforcement;
    private Date creationTime;
    private HashMap<int, OrderPart> parts;
  
    public void setStatus(OrderStatus status){}
    public boolean saveInDatabase(){}
    public void addOrderParts(OrderPart parts){}
  }
  
  public class LimitOrder extends Order {
  }
  
  public class StopLimitOrder extends Order {
  }
  
  public class StopLossOrder extends Order {}

public class MarketOrder extends Order {
}
