package com.scaler.lld.machinecoding.parkinglot.dtos;

/**
 * Author: Shrihari
 */
public class ParkingLotRequestDto {
    private int capacity;
    private String name;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
