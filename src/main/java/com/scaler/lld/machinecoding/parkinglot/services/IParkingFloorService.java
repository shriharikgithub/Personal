package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;

public interface IParkingFloorService {
    ParkingFloor createParkingFloor(int parkingFloorNumber, int parkingLotId) throws ParkingFloorCreationFailedException, ParkingLotNotFoundException, ParkingLotCreationFailedException;
    ParkingFloor getParkingFloorById(int parkingFloorId, int parkingLotId) throws ParkingFloorNotFoundException, ParkingLotNotFoundException;
}
