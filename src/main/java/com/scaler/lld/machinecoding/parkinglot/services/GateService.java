package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.GateCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GateNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.*;
import com.scaler.lld.machinecoding.parkinglot.repositories.IGateRepository;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public class GateService implements IGateService {

    private IGateRepository gateRepository;
    private IGateTypeService gateTypeService;
    private IParkingLotService parkingLotService;
    private IOperatorService operatorService;

    public GateService(IGateRepository gateRepository, IGateTypeService gateTypeService,
                       IParkingLotService parkingLotService, IOperatorService operatorService) {
        this.gateRepository = gateRepository;
        this.gateTypeService = gateTypeService;
        this.parkingLotService = parkingLotService;
        this.operatorService = operatorService;
    }

    @Override
    public Gate getGateByID(int gateId) throws GateNotFoundException {
        Optional<Gate> optionalGate = gateRepository.getGateByID(gateId);
        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException();
        }
        return optionalGate.get();
    }

    @Override
    public Gate createGate(int gateNumber, int parkingLotId, int operatorId, GateType gateType, GateStatus gateStatus) throws ParkingLotNotFoundException, OperatorNotFoundException, GateCreationFailedException {
        gateType = gateTypeService.createOrSave(gateType);
        ParkingLot parkingLot = parkingLotService.getParkingLotByLotId(parkingLotId);
        Operator operator = operatorService.getOperatorById(operatorId);
        Gate gate = gateRepository.save(gateNumber, parkingLot, operator, gateType, gateStatus);
        parkingLot = parkingLotService.addGateToParkingLot(parkingLot, gate);
        return gate;
    }
}
