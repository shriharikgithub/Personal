package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;
import com.scaler.lld.machinecoding.parkinglot.repositories.IParkingFloorRepository;
import com.scaler.lld.machinecoding.parkinglot.repositories.IParkingLotRepository;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public class ParkingFloorService implements IParkingFloorService {

    private IParkingFloorRepository parkingFloorRepository;
    private IParkingLotService parkingLotService;

    public ParkingFloorService(IParkingFloorRepository parkingFloorRepository, IParkingLotService parkingLotService) {
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotService = parkingLotService;
    }

    @Override
    public ParkingFloor createParkingFloor(int parkingFloorNumber, int parkingLotId) throws ParkingFloorCreationFailedException, ParkingLotNotFoundException, ParkingLotCreationFailedException {
        ParkingLot parkingLot = parkingLotService.getParkingLotByLotId(parkingLotId);
        Optional<ParkingFloor> optionalParkingFloor = parkingFloorRepository.getParkingFloor(parkingFloorNumber, parkingLot.getId());
        ParkingFloor parkingFloor = null;
        if (optionalParkingFloor.isEmpty()) {
             parkingFloor = parkingFloorRepository.save(parkingFloorNumber, parkingLot);
             parkingLot.addParkingFloor(parkingFloor);
             parkingLotService.save(parkingLot);
        } else {
            parkingFloor = optionalParkingFloor.get();
        }
        return parkingFloor;
    }

    @Override
    public ParkingFloor getParkingFloorById(int parkingFloorId, int parkingLotId) throws ParkingFloorNotFoundException, ParkingLotNotFoundException {
        ParkingLot parkingLot = parkingLotService.getParkingLotByLotId(parkingLotId);
        Optional<ParkingFloor> optionalParkingFloor = parkingFloorRepository.getParkingFloor(parkingFloorId, parkingLot);
        if (optionalParkingFloor.isEmpty()) {
            throw new ParkingFloorNotFoundException();
        } else {
            return optionalParkingFloor.get();
        }
    }
}
