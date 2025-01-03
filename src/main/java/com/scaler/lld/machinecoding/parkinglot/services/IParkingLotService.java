package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;

public interface IParkingLotService {
    ParkingLot getParkingLotByLotId(int parkingLotId) throws ParkingLotNotFoundException;
    ParkingLot createParkingLot(String name, int capacity) throws ParkingLotCreationFailedException;

    ParkingLot save(ParkingLot parkingLot) throws ParkingLotCreationFailedException;

    ParkingLot getParkingLotByGateId(int id) throws ParkingLotNotFoundException;

    ParkingLot addGateToParkingLot(ParkingLot parkingLotId, Gate gate) throws ParkingLotNotFoundException;
}
