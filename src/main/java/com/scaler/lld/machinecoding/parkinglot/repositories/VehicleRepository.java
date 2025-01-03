package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Vehicle;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class VehicleRepository implements IVehicleRepository {

    private Map<Integer, Vehicle> vehicleIdMap;
    private Map<String, Vehicle> vehicleNumberMap;
    private int lastSaveId;

    public VehicleRepository() {
        this.vehicleIdMap = new TreeMap<>();
        this.vehicleNumberMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public Optional<Vehicle> getVehicleByNumber(String vehicleNumber) {
        if (vehicleNumberMap.containsKey(vehicleNumber)) {
            return Optional.of(vehicleNumberMap.get(vehicleNumber));
        }
        return Optional.empty();
    }

    @Override
    public Vehicle save(String vehicleNumber, VehicleType vehicleType) {
        if (vehicleNumberMap.containsKey(vehicleNumber)) {
            Vehicle vehicle = vehicleNumberMap.get(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setUpdatedAt(new Date());
            return vehicle;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(++lastSaveId);
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setCreatedAt(new Date());
        vehicle.setUpdatedAt(new Date());
        vehicleIdMap.put(lastSaveId, vehicle);
        vehicleNumberMap.put(vehicleNumber, vehicle);
        return vehicle;
    }
}
