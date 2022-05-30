package com.ksoft.stepDefs;

public class ExecutionReport
{
    private String symbol;
    private String orderId;
    private String version;
    private Double price;
    private Double quantity;
    private String side;
    private String type;
    private String status;
    private String reason;
    private String owner;

    @Override
    public String toString() {
        return "ExecutioReport{" +
                "symbol='" + symbol + '\'' +
                ", orderId='" + orderId + '\'' +
                ", version='" + version + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", side='" + side + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public ExecutionReport(String symbol, String orderId, String version, Double price, Double quantity, String side, String type, String status, String reason, String owner) {

        this.symbol = symbol;
        this.orderId = orderId;
        this.version = version;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.type = type;
        this.status = status;
        this.reason = reason;
        this.owner = owner;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
