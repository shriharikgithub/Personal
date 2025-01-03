package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.models.GateType;
import com.scaler.lld.machinecoding.parkinglot.repositories.IGateTypeRepository;

/**
 * Author: Shrihari
 */
public class GateTypeService implements IGateTypeService {

    IGateTypeRepository gateTypeRepository;

    public GateTypeService(IGateTypeRepository gateTypeRepository) {
        this.gateTypeRepository = gateTypeRepository;
    }

    @Override
    public GateType createOrSave(GateType gateType) {
        gateType = gateTypeRepository.createOrSave(gateType);
        return gateType;
    }
}
