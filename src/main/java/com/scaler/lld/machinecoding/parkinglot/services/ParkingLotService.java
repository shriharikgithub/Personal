package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;
import com.scaler.lld.machinecoding.parkinglot.repositories.IParkingLotRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Shrihari
 */
public class ParkingLotService implements IParkingLotService {

    private IParkingLotRepository parkingLotRepository;
    public ParkingLotService(IParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot getParkingLotByLotId(int parkingLotId) throws ParkingLotNotFoundException {
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotByLotId(parkingLotId);
        if (optionalParkingLot.isEmpty()) {
            throw new ParkingLotNotFoundException();
        } else {
            return optionalParkingLot.get();
        }
    }

    @Override
    public ParkingLot createParkingLot(String name, int capacity) throws ParkingLotCreationFailedException {
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.save(name, capacity);
        if (optionalParkingLot.isEmpty()) {
            throw new ParkingLotCreationFailedException();
        } else {
            return optionalParkingLot.get();
        }
    }

    @Override
    public ParkingLot save(ParkingLot parkingLot) throws ParkingLotCreationFailedException {
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.save(parkingLot);
        if (optionalParkingLot.isEmpty()) {
            throw new ParkingLotCreationFailedException();
        } else {
            return optionalParkingLot.get();
        }
    }

    @Override
    public ParkingLot getParkingLotByGateId(int id) throws ParkingLotNotFoundException {
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotByGateId(id);
        if (optionalParkingLot.isEmpty()) {
            throw new ParkingLotNotFoundException();
        } else {
            return optionalParkingLot.get();
        }
    }

    @Override
    public ParkingLot addGateToParkingLot(ParkingLot parkingLot, Gate gate) throws ParkingLotNotFoundException {
        parkingLot = parkingLotRepository.update(parkingLot, gate);
        return parkingLot;
    }
}
