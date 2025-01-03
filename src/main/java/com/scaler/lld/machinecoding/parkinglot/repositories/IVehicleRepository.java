package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Vehicle;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;

import java.util.Optional;

public interface IVehicleRepository {

    Optional<Vehicle> getVehicleByNumber(String vehicleNumber);

    Vehicle save(String vehicleNumber, VehicleType vehicleType);
}
