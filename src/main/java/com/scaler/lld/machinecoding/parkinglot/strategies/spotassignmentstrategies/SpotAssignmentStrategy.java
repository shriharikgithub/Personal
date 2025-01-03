package com.scaler.lld.machinecoding.parkinglot.strategies.spotassignmentstrategies;

import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingSpot;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
