package com.scaler.lld.machinecoding.parkinglot.dtos;

/**
 * Author: Shrihari
 */
public class ParkingLotFloorResponseDto {
    private int id;
    private int floorNumber;
    private int parkingLotId;
    private FloorCreationStatus floorCreationStatus;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public FloorCreationStatus getFloorCreationStatus() {
        return floorCreationStatus;
    }

    public void setFloorCreationStatus(FloorCreationStatus floorCreationStatus) {
        this.floorCreationStatus = floorCreationStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    @Override
    public String toString() {
        return "ParkingLotFloorResponseDto{" +
                "id=" + id +
                ", floorNumber=" + floorNumber +
                ", parkingLotId=" + parkingLotId +
                ", floorCreationStatus=" + floorCreationStatus +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
