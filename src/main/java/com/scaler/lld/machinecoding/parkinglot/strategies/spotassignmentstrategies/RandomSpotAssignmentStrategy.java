package com.scaler.lld.machinecoding.parkinglot.strategies.spotassignmentstrategies;

import com.scaler.lld.machinecoding.parkinglot.models.*;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        return parkingLot
                .getParkingFloors()
                .stream()
                .flatMap(parkingFloor -> parkingFloor.getParkingSpots().stream())
                .filter(parkingSpot -> parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY))
                .filter(parkingSpot -> parkingSpot.getSupportedVehicleTypes().contains(vehicleType))
                .findAny();
    }
}
