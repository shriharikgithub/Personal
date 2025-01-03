package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingSpotRequestDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingSpotResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GlobalExceptionHandler;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.mappers.ParkingSpotMapper;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingSpot;
import com.scaler.lld.machinecoding.parkinglot.services.IParkingSpotService;

/**
 * Author: Shrihari
 */
public class ParkingSpotController {

    private IParkingSpotService parkingSpotService;

    public ParkingSpotController(IParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    public ParkingSpotResponseDto addParkingSpot(ParkingSpotRequestDto parkingSpotRequestDto) {
        ParkingSpotResponseDto parkingSpotResponseDto = new ParkingSpotResponseDto();
        try {
            ParkingSpot parkingSpot = parkingSpotService.addParkingSpot(parkingSpotRequestDto.getParkingSpotNumber(),
                    parkingSpotRequestDto.getParkingSpotStatus(), parkingSpotRequestDto.getSupportedVehicleTypes(),
                    parkingSpotRequestDto.getFloorId(), parkingSpotRequestDto.getParkingLotId(), parkingSpotRequestDto.getFloorNumber()
            );
            return ParkingSpotMapper.mapToDto(parkingSpot);
        } catch (ParkingFloorNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleParkingFloorNotFoundException(e);
            parkingSpotResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            parkingSpotResponseDto.setErrorMessage(errorMessage);
        } catch (ParkingSpotCreationFailedException e) {
            String errorMessage = GlobalExceptionHandler.handleParkingSpotCreationFailedException(e);
            parkingSpotResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            parkingSpotResponseDto.setErrorMessage(errorMessage);
        } catch (ParkingLotNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleParkingLotNotFoundException(e);
            parkingSpotResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            parkingSpotResponseDto.setErrorMessage(errorMessage);
        }
        return parkingSpotResponseDto;
    }
}
