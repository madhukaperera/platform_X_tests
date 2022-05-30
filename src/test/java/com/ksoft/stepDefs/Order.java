package com.ksoft.stepDefs;

public class Order
{
    private Double price;
    private Double quantity;
    private String side;
    private String type;
    private String symbol;
    private String owner;

    @Override
    public String toString()
    {
        return "{" +
                "price :" + price +
                ", quantity :" + quantity +
                ", side :'" + side + '\'' +
                ", type :'" + type + '\'' +
                ", symbol :'" + symbol + '\'' +
                ", owner :'" + owner + '\'' +
                '}';
    }

    public Order(String owner, String symbol, String type, String side, Double quantity, Double price)
    {
        this.owner = owner;
        this.symbol = symbol;
        this.type = type;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}

