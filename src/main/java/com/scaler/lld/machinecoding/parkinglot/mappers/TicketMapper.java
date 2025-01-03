package com.scaler.lld.machinecoding.parkinglot.mappers;

import com.scaler.lld.machinecoding.parkinglot.dtos.GenerateTicketResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

/**
 * Author: Shrihari
 */
public class TicketMapper {

    public static GenerateTicketResponseDto mapToDto(Ticket ticket) {
        GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
        generateTicketResponseDto.setEntryTime(ticket.getEntryTime());
        generateTicketResponseDto.setGateNumber(ticket.getGate().getGateNumber());
        generateTicketResponseDto.setOperaterName(ticket.getOperator().getName());
        generateTicketResponseDto.setParkingSpotNumber(ticket.getParkingSpot().getParkingSpotNumber());
        generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return generateTicketResponseDto;
    }
}
