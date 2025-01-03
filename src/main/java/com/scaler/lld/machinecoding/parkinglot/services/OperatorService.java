package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Operator;
import com.scaler.lld.machinecoding.parkinglot.repositories.IOperatorRepository;

import java.util.Optional;

/**
 * Author: Shrihari
 */
public class OperatorService implements IOperatorService {

    private IOperatorRepository operatorRepository;

    public OperatorService(IOperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public Operator getOperatorById(int operatorId) throws OperatorNotFoundException {
        Optional<Operator> optionalOperator = operatorRepository.getOperatorById(operatorId);
        if (optionalOperator.isEmpty()) {
            throw  new OperatorNotFoundException();
        } else {
            return optionalOperator.get();
        }
    }

    @Override
    public Operator addOperator(String name, String employeeId) throws OperatorCreationFailedException {
        Operator operator = operatorRepository.save(name, employeeId);
        return operator;
    }
}
