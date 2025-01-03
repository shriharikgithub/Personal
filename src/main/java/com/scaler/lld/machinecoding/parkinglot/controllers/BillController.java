package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.BillRequestDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.BillResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.exceptions.*;
import com.scaler.lld.machinecoding.parkinglot.mappers.BillMapper;
import com.scaler.lld.machinecoding.parkinglot.models.Bill;
import com.scaler.lld.machinecoding.parkinglot.services.IBillService;

/**
 * Author: Shrihari
 */
public class BillController {

    private IBillService billService;

    public BillController(IBillService billService) {
        this.billService = billService;
    }

    public BillResponseDto createBill(BillRequestDto billRequestDto) {
        BillResponseDto billResponseDto = new BillResponseDto();
        try {
            Bill bill = billService.createBill(billRequestDto.getTicketId(), billRequestDto.getVehicleNumber(), billRequestDto.getGateId());
            billResponseDto = BillMapper.mapToDto(bill);
            billResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (VehicleNotFoundException e) {
            String errorMsg = GlobalExceptionHandler.handleVehicleNotFoundException(e);
            billResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            billResponseDto.setErrorMessage(errorMsg);
        } catch (TicketNotFoundException e) {
            String errorMsg = GlobalExceptionHandler.handleTicketNotFoundException(e);
            billResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            billResponseDto.setErrorMessage(errorMsg);
        } catch (GateNotFoundException e) {
            String errorMsg = GlobalExceptionHandler.handleGateNotFoundException(e);
            billResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            billResponseDto.setErrorMessage(errorMsg);
        } catch (ParkingSpotNotFoundException e) {
            String errorMsg = GlobalExceptionHandler.handleParkingSpotNotFoundException(e);
            billResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            billResponseDto.setErrorMessage(errorMsg);
        }
        return billResponseDto;
    }
}
