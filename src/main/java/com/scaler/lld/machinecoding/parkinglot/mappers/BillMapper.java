package com.scaler.lld.machinecoding.parkinglot.mappers;

import com.scaler.lld.machinecoding.parkinglot.dtos.BillResponseDto;
import com.scaler.lld.machinecoding.parkinglot.models.Bill;
import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

/**
 * Author: Shrihari
 */
public class BillMapper {
    public static BillResponseDto mapToDto(Bill bill) {
        BillResponseDto billResponseDto = new BillResponseDto();
        billResponseDto.setAmount(bill.getAmount());
        billResponseDto.setExitTime(bill.getExitTime());
        billResponseDto.setOperatorName(bill.getGate().getCurrentOperator().getName());
        billResponseDto.setOnlinePaymentLink(bill.getOnlinePaymentLink());
        Ticket ticket = bill.getTicket();
        billResponseDto.setEntryTime(ticket.getEntryTime());
        billResponseDto.setVehicleNumber(ticket.getVehicle().getVehicleNumber());
        billResponseDto.setEntryGateId(ticket.getGate().getId());
        billResponseDto.setExitGateId(bill.getGate().getId());
        billResponseDto.setParkingSpotNumber(ticket.getParkingSpot().getParkingSpotNumber());
        return billResponseDto;
    }
}
