package com.scaler.lld.machinecoding.parkinglot.controllers;

import com.scaler.lld.machinecoding.parkinglot.dtos.OperatorRequestDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.OperatorResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.exceptions.GlobalExceptionHandler;
import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.mappers.OperatorMapper;
import com.scaler.lld.machinecoding.parkinglot.models.Operator;
import com.scaler.lld.machinecoding.parkinglot.repositories.IOperatorRepository;
import com.scaler.lld.machinecoding.parkinglot.services.IOperatorService;

/**
 * Author: Shrihari
 */
public class OperatorController {

    private IOperatorService operatorService;

    public OperatorController(IOperatorService operatorService) {
        this.operatorService = operatorService;
    }

    public OperatorResponseDto createOperator(OperatorRequestDto operatorRequestDto) {
        OperatorResponseDto operatorResponseDto = new OperatorResponseDto();
        try {
            Operator operator = operatorService.addOperator(operatorRequestDto.getName(), operatorRequestDto.getEmployeeID());
            return OperatorMapper.mapToDto(operator);
        } catch (OperatorCreationFailedException e) {
            GlobalExceptionHandler.handleOperatorCreationFailedException(e);
            operatorResponseDto.setStatus(ResponseStatus.FAILURE);
            operatorResponseDto.setErrorMessage(e.getMessage());
            return operatorResponseDto;
        }
    }
}
