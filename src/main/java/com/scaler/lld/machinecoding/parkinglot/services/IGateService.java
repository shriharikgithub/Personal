package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.GateCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GateNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.GateStatus;
import com.scaler.lld.machinecoding.parkinglot.models.GateType;

import java.util.Optional;

public interface IGateService {
    Gate getGateByID(int gateId) throws GateNotFoundException;
    Gate createGate(int gateNumber, int parkingLotId, int operatorId, GateType gateType, GateStatus gateStatus) throws ParkingLotNotFoundException, OperatorNotFoundException, GateCreationFailedException;
}
