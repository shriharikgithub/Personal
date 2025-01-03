package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.*;

import java.util.*;

/**
 * Author: Shrihari
 */
public class ParkingLotRepository implements IParkingLotRepository {

    private Map<Integer, ParkingLot> parkingLotIdMap;
    private int lastSaveId;

    public ParkingLotRepository() {
        this.parkingLotIdMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public Optional<ParkingLot> save(String name, int capacity) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(lastSaveId + 1);
        parkingLot.setCapacity(capacity);
        parkingLot.setCreatedAt(new Date());
        parkingLot.setUpdatedAt(new Date());
        parkingLot.setParkingLotName(name);
        parkingLotIdMap.put(++lastSaveId, parkingLot);
        return Optional.of(parkingLot);
    }

    @Override
    public Optional<ParkingLot> save(ParkingLot parkingLot) {
        if (parkingLotIdMap.containsKey(parkingLot.getId())) {
            parkingLotIdMap.replace(parkingLot.getId(), parkingLot);
            parkingLot.setUpdatedAt(new Date());
            return Optional.of(parkingLot);
        } else {
            parkingLot.setId(++lastSaveId);
            parkingLot.setCreatedAt(new Date());
            parkingLot.setUpdatedAt(new Date());
            return Optional.of(parkingLot);
        }
    }

    @Override
    public Optional<ParkingLot> getParkingLotByGateId(int gateId) {
        return parkingLotIdMap
                .values()
                .stream()
                .filter(p -> p.getGates()
                        .stream()
                        .anyMatch(g -> g.getId() == gateId))
                .findFirst();
    }

    @Override
    public ParkingLot update(ParkingLot parkingLot, Gate gate) throws ParkingLotNotFoundException {
        Optional<ParkingLot> optionalParkingLot = getParkingLotByLotId(parkingLot.getId());
        if (optionalParkingLot.isEmpty()) {
            throw new ParkingLotNotFoundException();
        } else {
            ParkingLot updatedParkingLot = optionalParkingLot.get();
            updatedParkingLot.setUpdatedAt(new Date());
            updatedParkingLot.getGates().add(gate);
            return updatedParkingLot;
        }
    }

    @Override
    public Optional<ParkingLot> getParkingLotByLotId(int parkingLotId) {
        if (parkingLotIdMap.containsKey(parkingLotId)) {
            return Optional.of(parkingLotIdMap.get(parkingLotId));
        } else {
            return Optional.empty();
        }
    }
}
