package com.scaler.lld.machinecoding.parkinglot.dtos;

import java.util.Date;

/**
 * Author: Shrihari
 */
public class BillResponseDto {
    private Date entryTime;
    private Date exitTime;
    private String operatorName;
    private int amount;
    private String onlinePaymentLink;
    private String vehicleNumber;
    private int entryGateId;
    private int exitGateId;
    private int parkingSpotNumber;
    private ResponseStatus responseStatus;
    private String errorMessage;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getEntryGateId() {
        return entryGateId;
    }

    public void setEntryGateId(int entryGateId) {
        this.entryGateId = entryGateId;
    }

    public int getExitGateId() {
        return exitGateId;
    }

    public void setExitGateId(int exitGateId) {
        this.exitGateId = exitGateId;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    @Override
    public String toString() {
        return "BillResponseDto{" +
                "entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", operatorName='" + operatorName + '\'' +
                ", amount=" + amount +
                ", onlinePaymentLink='" + onlinePaymentLink + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", entryGateId=" + entryGateId +
                ", exitGateId=" + exitGateId +
                ", parkingSpotNumber=" + parkingSpotNumber +
                ", responseStatus=" + responseStatus +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
