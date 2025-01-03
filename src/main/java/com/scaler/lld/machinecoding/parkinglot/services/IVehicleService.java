package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.models.Vehicle;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;

public interface IVehicleService {
    Vehicle getOrCreateVehicle(String vehicleNumber, VehicleType vehicleType);
}
