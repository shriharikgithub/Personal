package com.scaler.lld.machinecoding.parkinglot.mappers;

import com.scaler.lld.machinecoding.parkinglot.dtos.OperatorResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.models.Operator;

/**
 * Author: Shrihari
 */
public class OperatorMapper {
    public static OperatorResponseDto mapToDto(Operator operator) {
        OperatorResponseDto operatorResponseDto = new OperatorResponseDto();
        operatorResponseDto.setEmployeeId(operator.getEmployeeID());
        operatorResponseDto.setId(operator.getId());
        operatorResponseDto.setName(operator.getName());
        operatorResponseDto.setStatus(ResponseStatus.SUCCESS);
        return operatorResponseDto;
    }
}
