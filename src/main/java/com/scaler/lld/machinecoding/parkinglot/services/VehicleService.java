package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.models.Vehicle;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;
import com.scaler.lld.machinecoding.parkinglot.repositories.IVehicleRepository;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public class VehicleService implements IVehicleService {

    private IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle getOrCreateVehicle(String vehicleNumber, VehicleType vehicleType) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByNumber(vehicleNumber);
        Vehicle vehicle = null;
        if (optionalVehicle.isEmpty()) {
            vehicle = vehicleRepository.save(vehicleNumber, vehicleType);
        } else {
            vehicle = optionalVehicle.get();
        }
        return vehicle;
    }
}
