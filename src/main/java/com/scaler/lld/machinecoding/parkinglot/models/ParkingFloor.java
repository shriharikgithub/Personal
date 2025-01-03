package com.scaler.lld.machinecoding.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor extends BaseModel {

    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
    private int parkingLotId;

    public ParkingFloor() {
        this.parkingSpots = new ArrayList<>();
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }
}
