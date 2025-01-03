package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingSpot;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingSpotStatus;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;

import java.util.List;
import java.util.Optional;

/**
 * Author: Shrihari
 */
public interface IParkingSpotService {
    ParkingSpot update(ParkingSpot parkingSpot) throws ParkingSpotNotFoundException;
    ParkingSpot addParkingSpot(int spotNumber,
                               ParkingSpotStatus parkingSpotStatus,
                               List<VehicleType> supportedVehicleTypes,
                               int floorId,
                               int parkingLotId,
                               int floorNumber) throws ParkingLotNotFoundException, ParkingFloorNotFoundException,
            ParkingSpotCreationFailedException;
}
