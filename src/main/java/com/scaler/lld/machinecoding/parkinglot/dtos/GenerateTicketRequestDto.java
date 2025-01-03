package com.scaler.lld.machinecoding.parkinglot.dtos;

import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;

/**
 * Author: Shrihari
 */
public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private int gateID;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGateID() {
        return gateID;
    }

    public void setGateID(int gateID) {
        this.gateID = gateID;
    }
}
