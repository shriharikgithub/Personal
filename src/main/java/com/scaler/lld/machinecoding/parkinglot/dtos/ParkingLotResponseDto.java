package com.scaler.lld.machinecoding.parkinglot.dtos;

import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;

import java.util.List;

/**
 * Author: Shrihari
 */
public class ParkingLotResponseDto {
    private int id;
    private String name;
    private int capacity;
    private ParkingLotCreateStatus parkingLotCreateStatus;

    public ParkingLotCreateStatus getParkingLotCreateStatus() {
        return parkingLotCreateStatus;
    }

    public void setParkingLotCreateStatus(ParkingLotCreateStatus parkingLotCreateStatus) {
        this.parkingLotCreateStatus = parkingLotCreateStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "ParkingLotResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", parkingLotCreateStatus=" + parkingLotCreateStatus +
                '}';
    }
}
