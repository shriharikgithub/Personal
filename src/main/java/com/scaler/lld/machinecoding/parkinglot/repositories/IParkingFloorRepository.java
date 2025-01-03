package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public interface IParkingFloorRepository {
    ParkingFloor save(int parkingFloorNumber, ParkingLot parkingLot) throws ParkingFloorCreationFailedException;
    Optional<ParkingFloor> getParkingFloor(int parkingFloorNumber, int parkingLotId);

    Optional<ParkingFloor> getParkingFloor(int parkingFloorId, ParkingLot parkingLot);
}
