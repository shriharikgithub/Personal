package com.scaler.lld.machinecoding.parkinglot.mappers;

import com.scaler.lld.machinecoding.parkinglot.dtos.FloorCreationStatus;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingLotCreateStatus;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingLotFloorResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingLotResponseDto;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingFloor;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingLot;

/**
 * Author: Shrihari
 */
public class ParkingLotMapper {
    public static ParkingLotResponseDto maptoDto(ParkingLot parkingLot) {
        ParkingLotResponseDto parkingLotResponseDto = new ParkingLotResponseDto();
        parkingLotResponseDto.setId(parkingLot.getId());
        parkingLotResponseDto.setCapacity(parkingLot.getCapacity());
        parkingLotResponseDto.setName(parkingLot.getParkingLotName());
        parkingLotResponseDto.setParkingLotCreateStatus(ParkingLotCreateStatus.CREATED);
        return parkingLotResponseDto;
    }

    public static ParkingLotFloorResponseDto maptoDto(ParkingFloor parkingFloor) {
        ParkingLotFloorResponseDto parkingLotFloorResponseDto = new ParkingLotFloorResponseDto();
        parkingLotFloorResponseDto.setFloorNumber(parkingFloor.getFloorNumber());
        parkingLotFloorResponseDto.setParkingLotId(parkingFloor.getParkingLotId());
        parkingLotFloorResponseDto.setId(parkingFloor.getId());
        parkingLotFloorResponseDto.setFloorCreationStatus(FloorCreationStatus.CREATED);
        return parkingLotFloorResponseDto;
    }
}
