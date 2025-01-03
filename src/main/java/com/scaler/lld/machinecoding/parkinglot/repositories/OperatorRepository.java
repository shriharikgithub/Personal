package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Operator;
import com.scaler.lld.machinecoding.parkinglot.services.OperatorService;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class OperatorRepository implements IOperatorRepository {

    private Map<Integer, Operator> operatorMap;
    private int lastSaveId;

    public OperatorRepository() {
        this.operatorMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public Optional<Operator> getOperatorById(int operatorId) {
        if (operatorMap.containsKey(operatorId)) {
            return Optional.of(operatorMap.get(operatorId));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Operator> getOperatorByEmployeeId(String employeeId) {
        return operatorMap
                .values()
                .stream()
                .filter(operator -> operator.getEmployeeID() == employeeId)
                .findFirst();
    }

    @Override
    public Operator save(String name, String employeeId) {
        Optional<Operator> optionalOperator = getOperatorByEmployeeId(employeeId);
        if (optionalOperator.isEmpty()) {
            Operator operator = new Operator();
            operator.setName(name);
            operator.setEmployeeID(employeeId);
            operator.setId(++lastSaveId);
            operator.setCreatedAt(new Date());
            operator.setUpdatedAt(new Date());
            operatorMap.put(lastSaveId, operator);
            return operator;
        } else {
            Operator operator = optionalOperator.get();
            operator.setName(name);
            operator.setUpdatedAt(new Date());
            return operator;
        }
    }
}
