package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.GenerateTicketRequestDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.GenerateTicketResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.exceptions.*;
import com.scaler.lld.machinecoding.parkinglot.mappers.TicketMapper;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.Ticket;
import com.scaler.lld.machinecoding.parkinglot.models.Vehicle;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;
import com.scaler.lld.machinecoding.parkinglot.services.IGateService;
import com.scaler.lld.machinecoding.parkinglot.services.ITicketService;
import com.scaler.lld.machinecoding.parkinglot.services.IVehicleService;

/**
 * Author: Shrihari
 */
public class TicketController {

    private ITicketService ticketService;
    private IVehicleService vehicleService;
    private IGateService gateService;

    public TicketController(ITicketService ticketService,
                            IVehicleService vehicleService,
                            IGateService gateService) {
        this.ticketService = ticketService;
        this.vehicleService = vehicleService;
        this.gateService = gateService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {

        GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
        String vehicleNumber = generateTicketRequestDto.getVehicleNumber();
        VehicleType vehicleType = generateTicketRequestDto.getVehicleType();
        int gateId = generateTicketRequestDto.getGateID();

        try {
            Vehicle vehicle = vehicleService.getOrCreateVehicle(vehicleNumber, vehicleType);
            Gate gate = gateService.getGateByID(gateId);
            Ticket ticket = ticketService.generateTicket(vehicle, gate);
            generateTicketResponseDto = TicketMapper.mapToDto(ticket);
            return generateTicketResponseDto;
        } catch (GateNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleGateNotFoundException(e);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setErrorMessage(errorMessage);
            return generateTicketResponseDto;
        } catch (OperatorNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleOperatorNotFoundException(e);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setErrorMessage(errorMessage);
            return generateTicketResponseDto;
        } catch (ParkingLotNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleParkingLotNotFoundException(e);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setErrorMessage(errorMessage);
            return generateTicketResponseDto;
        } catch (ParkingSpotNotFoundException e) {
            String errorMessage = GlobalExceptionHandler.handleParkingSpotNotFoundException(e);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setErrorMessage(errorMessage);
            return generateTicketResponseDto;
        }
    }
}
