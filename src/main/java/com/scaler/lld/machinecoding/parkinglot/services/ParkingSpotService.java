package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.*;
import com.scaler.lld.machinecoding.parkinglot.repositories.IParkingSpotRepository;

import java.util.List;

/**
 * Author: Shrihari
 */
public class ParkingSpotService implements IParkingSpotService {

    private IParkingSpotRepository parkingSpotRepository;
    private IParkingLotService parkingLotService;
    private IParkingFloorService parkingFloorService;

    public ParkingSpotService(IParkingSpotRepository parkingSpotRepository,
                              IParkingLotService parkingLotService,
                              IParkingFloorService parkingFloorService) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotService = parkingLotService;
        this.parkingFloorService = parkingFloorService;
    }

    @Override
    public ParkingSpot update(ParkingSpot parkingSpot) throws ParkingSpotNotFoundException {
        parkingSpot = parkingSpotRepository.update(parkingSpot);
        return parkingSpot;
    }

    @Override
    public ParkingSpot addParkingSpot(int spotNumber, ParkingSpotStatus parkingSpotStatus, List<VehicleType> supportedVehicleTypes, int floorId, int parkingLotId,
                                      int floorNumber) throws ParkingLotNotFoundException, ParkingFloorNotFoundException, ParkingSpotCreationFailedException
            {
        // Check if parking lot exists
        // Check if the floor exists
        // Add the spot;
        ParkingLot parkingLot = parkingLotService.getParkingLotByLotId(parkingLotId);
        ParkingFloor parkingFloor = parkingFloorService.getParkingFloorById(floorId, parkingLotId);
        ParkingSpot parkingSpot = parkingSpotRepository.save(parkingFloor, spotNumber, parkingSpotStatus,
                supportedVehicleTypes);
        return parkingSpot;
    }
}
