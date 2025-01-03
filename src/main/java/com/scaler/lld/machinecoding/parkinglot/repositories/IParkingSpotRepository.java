package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.*;

import java.util.List;

public interface IParkingSpotRepository {
    ParkingSpot update(ParkingSpot parkingSpot) throws ParkingSpotNotFoundException;

    ParkingSpot save(ParkingFloor parkingFloor, int spotNumber, ParkingSpotStatus parkingSpotStatus, List<VehicleType> supportedVehicleTypes);
}
