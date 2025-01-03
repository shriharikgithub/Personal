package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.*;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GlobalExceptionHandler;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.mappers.ParkingLotMapper;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;
import com.scaler.lld.machinecoding.parkinglot.services.IParkingLotService;

import java.util.List;

/**
 * Author: Shrihari
 */
public class ParkingLotController {

    private IParkingLotService parkingLotService;

    public ParkingLotController(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public ParkingLotResponseDto createParkingLot(ParkingLotRequestDto parkingLotRequestDto) {
        ParkingLotResponseDto parkingLotResponseDto = null;
        try {
            String name = parkingLotRequestDto.getName();
            int capacity = parkingLotRequestDto.getCapacity();
            ParkingLot parkingLot = parkingLotService.createParkingLot(name, capacity);
            parkingLotResponseDto = ParkingLotMapper.maptoDto(parkingLot);
            return parkingLotResponseDto;
        } catch (ParkingLotCreationFailedException e) {
            GlobalExceptionHandler.handleParkingLotCreationFailedException(e);
            parkingLotResponseDto.setParkingLotCreateStatus(ParkingLotCreateStatus.FAILED);
            return parkingLotResponseDto;
        }
    }
}
