package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.GateRequestDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.GateResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GateCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GlobalExceptionHandler;
import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.mappers.GateMapper;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.GateStatus;
import com.scaler.lld.machinecoding.parkinglot.models.GateType;
import com.scaler.lld.machinecoding.parkinglot.services.IGateService;

/**
 * Author: Shrihari
 */
public class GateController {

    private IGateService gateService;

    public GateController(IGateService gateService) {
        this.gateService = gateService;
    }

    public GateResponseDto createGate(GateRequestDto gateRequestDto) {
        GateResponseDto gateResponseDto = new GateResponseDto();
        try {
            int gateNumber = gateRequestDto.getGateNumber();
            int parkingLotId = gateRequestDto.getParkingLotId();
            int operatorId = gateRequestDto.getOperatorId();
            GateType gateType = gateRequestDto.getGateType();
            GateStatus gateStatus = gateRequestDto.getGateStatus();
            Gate gate = gateService.createGate(gateNumber, parkingLotId, operatorId, gateType, gateStatus);
            gateResponseDto = GateMapper.mapToDto(gate);
        } catch (GateCreationFailedException e) {
            String errorMessage = GlobalExceptionHandler.handleGateCreationFailedException(e);
            gateResponseDto.setGateNumber(gateRequestDto.getGateNumber());
            gateResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            gateResponseDto.setErrorMessage(errorMessage);
        } catch (OperatorNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleOperatorNotFoundException(e);
            gateResponseDto.setGateNumber(gateRequestDto.getGateNumber());
            gateResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            gateResponseDto.setErrorMessage(errorMessage);
        } catch (ParkingLotNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleParkingLotNotFoundException(e);
            gateResponseDto.setGateNumber(gateRequestDto.getGateNumber());
            gateResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            gateResponseDto.setErrorMessage(errorMessage);
        }
        return gateResponseDto;
    }
}
