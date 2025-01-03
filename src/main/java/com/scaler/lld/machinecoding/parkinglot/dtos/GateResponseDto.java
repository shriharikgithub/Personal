package com.scaler.lld.machinecoding.parkinglot.dtos;

/**
 * Author: Shrihari
 */
public class GateResponseDto {
    private int gateId;
    private int gateNumber;
    private String currentOperatorName;
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

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getCurrentOperatorName() {
        return currentOperatorName;
    }

    public void setCurrentOperatorName(String currentOperatorName) {
        this.currentOperatorName = currentOperatorName;
    }

    @Override
    public String toString() {
        return "GateResponseDto{" +
                "gateId=" + gateId +
                ", gateNumber=" + gateNumber +
                ", currentOperatorName='" + currentOperatorName + '\'' +
                ", responseStatus=" + responseStatus +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
