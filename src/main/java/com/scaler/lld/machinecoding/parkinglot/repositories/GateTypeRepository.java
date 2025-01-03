package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.GateType;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class GateTypeRepository implements IGateTypeRepository {

    private Map<Integer, GateType> gateTypeMap;
    private int lastSaveId;

    public GateTypeRepository() {
        this.gateTypeMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    private Optional<GateType> getGateType(GateType gateType) {
        return gateTypeMap
                .values()
                .stream()
                .filter(g -> g.equals(gateType))
                .findFirst();
    }

    @Override
    public GateType createOrSave(GateType gateType) {
        Optional<GateType> optionalGateType = getGateType(gateType);
        if (optionalGateType.isPresent()) {
            return optionalGateType.get();
        } else {
            gateTypeMap.put(++lastSaveId, gateType);
            return gateType;
        }
    }
}
