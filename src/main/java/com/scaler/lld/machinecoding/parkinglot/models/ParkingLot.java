package com.scaler.lld.machinecoding.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseModel {

    private String parkingLotName;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private int capacity;

    public ParkingLot() {
        this.parkingFloors = new ArrayList<>();
        this.gates = new ArrayList<>();
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }
}
