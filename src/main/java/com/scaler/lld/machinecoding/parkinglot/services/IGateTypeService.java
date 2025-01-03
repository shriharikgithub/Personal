package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.models.GateType;

public interface IGateTypeService {
    GateType createOrSave(GateType gateType);
}
