package com.scaler.lld.machinecoding.parkinglot.dtos;

/**
 * Author: Shrihari
 */
public class ParkingLotFloorRequestDto {

    private int floorNumber;
    private int parkingLotId;

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
}
