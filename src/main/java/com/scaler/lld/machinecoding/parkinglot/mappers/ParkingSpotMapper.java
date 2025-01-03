package com.scaler.lld.machinecoding.parkinglot.mappers;

import com.scaler.lld.machinecoding.parkinglot.dtos.ParkingSpotResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.models.ParkingSpot;

/**
 * Author: Shrihari
 */
public class ParkingSpotMapper {
    public static ParkingSpotResponseDto mapToDto(ParkingSpot parkingSpot) {
        ParkingSpotResponseDto parkingSpotResponseDto = new ParkingSpotResponseDto();
        parkingSpotResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        parkingSpotResponseDto.setParkingSpotNumber(parkingSpot.getParkingSpotNumber());
        parkingSpotResponseDto.setParkingSpotId(parkingSpot.getId());
        parkingSpotResponseDto.setParkingSpotStatus(parkingSpot.getParkingSpotStatus());
        return parkingSpotResponseDto;
    }
}
