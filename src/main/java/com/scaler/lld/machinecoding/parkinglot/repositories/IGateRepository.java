package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.*;

import java.util.Optional;

public interface IGateRepository {
    Optional<Gate> getGateByID(int gateId);

    Gate save(int gateNumber, ParkingLot parkingLot, Operator operator, GateType gateType, GateStatus gateStatus);
}
