package com.scaler.lld.machinecoding.parkinglot.dtos;

import com.scaler.lld.machinecoding.parkinglot.models.GateStatus;
import com.scaler.lld.machinecoding.parkinglot.models.GateType;

/**
 * Author: Shrihari
 */
public class GateRequestDto {
    private int gateNumber;
    private int parkingLotId;
    private int operatorId;
    private GateType gateType;
    private GateStatus gateStatus;

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }
}
