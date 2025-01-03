package com.scaler.lld.machinecoding.parkinglot.models;

import java.util.Date;

public class Bill extends BaseModel {

    private Date exitTime;
    private Ticket ticket;
    private Operator operator;
    private int amount;
    private String onlinePaymentLink;

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOnlinePaymentLink() {
        return onlinePaymentLink;
    }

    public void setOnlinePaymentLink(String onlinePaymentLink) {
        this.onlinePaymentLink = onlinePaymentLink;
    }
}
