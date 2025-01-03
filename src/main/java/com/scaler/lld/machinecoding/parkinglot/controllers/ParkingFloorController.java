package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.FloorCreationStatus;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingLotFloorRequestDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingLotFloorResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingLotResponseDto;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingFloorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.mappers.ParkingLotMapper;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;
import com.scaler.lld.machinecoding.parkinglot.services.IParkingFloorService;

/**
 * Author: Shrihari
 */
public class ParkingFloorController {

    private IParkingFloorService parkingFloorService;

    public ParkingFloorController(IParkingFloorService parkingFloorService) {
        this.parkingFloorService = parkingFloorService;
    }

    public ParkingLotFloorResponseDto createParkingFloor(ParkingLotFloorRequestDto parkingLotFloorRequestDto) {
        ParkingLotFloorResponseDto parkingLotFloorResponseDto = new ParkingLotFloorResponseDto();
        try {
            int parkingFloorNumber = parkingLotFloorRequestDto.getFloorNumber();
            int parkingLotId = parkingLotFloorRequestDto.getParkingLotId();
            ParkingFloor parkingFloor = parkingFloorService.createParkingFloor(parkingFloorNumber, parkingLotId);
            parkingLotFloorResponseDto = ParkingLotMapper.maptoDto(parkingFloor);
            return parkingLotFloorResponseDto;
        } catch (ParkingFloorCreationFailedException e) {
            parkingLotFloorResponseDto.setFloorCreationStatus(FloorCreationStatus.FAILED);
            parkingLotFloorResponseDto.setErrorMessage("Parking floor creation failed " + e.getMessage());
            return parkingLotFloorResponseDto;
        } catch (ParkingLotNotFoundException e) {
            parkingLotFloorResponseDto.setFloorCreationStatus(FloorCreationStatus.FAILED);
            parkingLotFloorResponseDto.setErrorMessage("Parking floor creation failed " + e.getMessage());
            return parkingLotFloorResponseDto;
        } catch (ParkingLotCreationFailedException e) {
            parkingLotFloorResponseDto.setFloorCreationStatus(FloorCreationStatus.FAILED);
            parkingLotFloorResponseDto.setErrorMessage("Parking lot updation failed " + e.getMessage());
            return parkingLotFloorResponseDto;
        }
    }
}
