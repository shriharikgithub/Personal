package com.scaler.lld.machinecoding.parkinglot.dtos;

/**
 * Author: Shrihari
 */
public class BillRequestDto {
    private String vehicleNumber;
    private int ticketId;
    private int gateId;

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
