package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.*;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class GateRepository implements IGateRepository {

    private Map<Integer, Gate> gateMap;
    private int lastSaveId;

    public GateRepository() {
        this.gateMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public Optional<Gate> getGateByID(int gateId) {
        if (gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Gate> getGateByNumber(int gateNumber) {
        return gateMap
                .values()
                .stream()
                .filter(gate -> gate.getGateNumber() == gateNumber)
                .findFirst();
    }

    @Override
    public Gate save(int gateNumber, ParkingLot parkingLot, Operator operator, GateType gateType, GateStatus gateStatus) {
        Optional<Gate> optionalGate = getGateByNumber(gateNumber);
        Gate gate = null;
        if (optionalGate.isEmpty()) {
            gate = new Gate();
            gate.setId(++lastSaveId);
            gate.setCurrentOperator(operator);
            gate.setGateStatus(gateStatus);
            gate.setGateType(gateType);
            gate.setGateNumber(gateNumber);
            gate.setCreatedAt(new Date());
            gate.setUpdatedAt(new Date());
            gateMap.put(lastSaveId, gate);
            return gate;
        } else {
            gate = new Gate();
            gate.setCurrentOperator(operator);
            gate.setGateStatus(gateStatus);
            gate.setGateType(gateType);
            gate.setGateNumber(gateNumber);
            gate.setUpdatedAt(new Date());
            return gate;
        }
    }
}
