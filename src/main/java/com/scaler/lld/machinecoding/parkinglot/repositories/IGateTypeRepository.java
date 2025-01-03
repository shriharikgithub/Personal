package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.GateType;

public interface IGateTypeRepository {
    GateType createOrSave(GateType gateType);
}
