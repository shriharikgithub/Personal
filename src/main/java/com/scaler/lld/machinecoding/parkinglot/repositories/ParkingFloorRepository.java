package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class ParkingFloorRepository implements IParkingFloorRepository {

    private Map<Integer, ParkingFloor> parkingFloorMap;
    private int lastSaveId;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public Optional<ParkingFloor> getParkingFloor(int parkingFloorNumber, int parkingLotId) {
        return parkingFloorMap
                .values()
                .stream()
                .filter(parkingFloor -> parkingFloor.getFloorNumber() == parkingFloorNumber)
                .filter(parkingFloor -> parkingFloor.getParkingLotId() == parkingLotId)
                .findFirst();
    }

    @Override
    public Optional<ParkingFloor> getParkingFloor(int parkingFloorId, ParkingLot parkingLot) {
        return parkingFloorMap
                .values()
                .stream()
                .filter(p -> p.getParkingLotId() == parkingLot.getId())
                .filter(p -> p.getId() == parkingFloorId)
                .findFirst();
    }

    @Override
    public ParkingFloor save(int parkingFloorNumber, ParkingLot parkingLot) {
        Optional<ParkingFloor> optionalParkingFloor = getParkingFloor(parkingFloorNumber, parkingLot.getId());
        if (optionalParkingFloor.isEmpty()) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setCreatedAt(new Date());
            parkingFloor.setUpdatedAt(new Date());
            parkingFloor.setFloorNumber(parkingFloorNumber);
            parkingFloor.setParkingLotId(parkingLot.getId());
            parkingFloorMap.put(++lastSaveId, parkingFloor);
            return parkingFloorMap.get(lastSaveId);
        } else {
            return optionalParkingFloor.get();
        }
    }
}
