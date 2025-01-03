package com.scaler.lld.machinecoding.parkinglot.mappers;

import com.scaler.lld.machinecoding.parkinglot.dtos.GateResponseDto;
import com.scaler.lld.machinecoding.parkinglot.dtos.ResponseStatus;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;

/**
 * Author: Shrihari
 */
public class GateMapper {
    public static GateResponseDto mapToDto(Gate gate) {
        GateResponseDto gateResponseDto = new GateResponseDto();
        gateResponseDto.setGateNumber(gate.getGateNumber());
        gateResponseDto.setCurrentOperatorName(gate.getCurrentOperator().getName());
        gateResponseDto.setGateId(gate.getId());
        gateResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return gateResponseDto;
    }
}
