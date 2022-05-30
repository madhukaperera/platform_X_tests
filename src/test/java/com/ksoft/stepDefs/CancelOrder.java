package com.ksoft.stepDefs;

public class CancelOrder {

    private String symbol;
    private String orderID;

    @Override
    public String toString() {
        return "CancelOrder{" +
                "symbol='" + symbol + '\'' +
                ", orderID='" + orderID + '\'' +
                '}';
    }

    public CancelOrder (String symbol, String orderID)
    {
        this.symbol = symbol;
        this.orderID = orderID;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
