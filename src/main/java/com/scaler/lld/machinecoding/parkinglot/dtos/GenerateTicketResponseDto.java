package com.scaler.lld.machinecoding.parkinglot.dtos;

import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;

import java.util.Date;

/**
 * Author: Shrihari
 */
public class GenerateTicketResponseDto {
    private int parkingSpotNumber;
    private Date entryTime;
    private int gateNumber;
    private String operaterName;
    private ResponseStatus responseStatus;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getOperaterName() {
        return operaterName;
    }

    public void setOperaterName(String operaterName) {
        this.operaterName = operaterName;
    }

    @Override
    public String toString() {
        return "GenerateTicketResponseDto{" +
                "parkingSpotNumber=" + parkingSpotNumber +
                ", entryTime=" + entryTime +
                ", gateNumber=" + gateNumber +
                ", operaterName='" + operaterName + '\'' +
                ", responseStatus=" + responseStatus +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
