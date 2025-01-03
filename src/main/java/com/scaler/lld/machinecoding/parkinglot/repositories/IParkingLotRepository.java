package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;

import java.util.Optional;

public interface IParkingLotRepository {
    Optional<ParkingLot> save(String name, int capacity);

    Optional<ParkingLot> save(ParkingLot parkingLot);

    Optional<ParkingLot> getParkingLotByLotId(int parkingLotId);

    Optional<ParkingLot> getParkingLotByGateId(int gateId);

    ParkingLot update(ParkingLot parkingLot, Gate gate) throws ParkingLotNotFoundException;
}
