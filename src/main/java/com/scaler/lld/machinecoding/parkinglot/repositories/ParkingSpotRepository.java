package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.*;

import java.util.*;

/**
 * Author: Shrihari
 */
public class ParkingSpotRepository implements IParkingSpotRepository {

    private Map<Integer, ParkingSpot> parkingSpotMap;
    private int lastSaveId;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public ParkingSpot update(ParkingSpot parkingSpot) throws ParkingSpotNotFoundException {
        int parkingSpotId = parkingSpot.getId();
        if (parkingSpotMap.containsKey(parkingSpotId)) {
            parkingSpotMap.get(parkingSpotId).setVehicle(parkingSpot.getVehicle());
            parkingSpotMap.get(parkingSpotId).setParkingSpotStatus(parkingSpot.getParkingSpotStatus());
            parkingSpotMap.get(parkingSpotId).setUpdatedAt(new Date());
            return parkingSpotMap.get(parkingSpotId);
        } else {
            throw new ParkingSpotNotFoundException();
        }
    }

    @Override
    public ParkingSpot save(ParkingFloor parkingFloor, int spotNumber, ParkingSpotStatus parkingSpotStatus, List<VehicleType> supportedVehicleTypes) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotStatus(parkingSpotStatus);
        parkingSpot.setParkingSpotNumber(spotNumber);
        parkingSpot.setSupportedVehicleTypes(supportedVehicleTypes);
        parkingSpot.setId(++lastSaveId);
        parkingSpot.setCreatedAt(new Date());
        parkingSpot.setUpdatedAt(new Date());
        parkingFloor.addParkingSpot(parkingSpot);
        parkingSpotMap.put(lastSaveId, parkingSpot);
        return parkingSpot;
    }
}
