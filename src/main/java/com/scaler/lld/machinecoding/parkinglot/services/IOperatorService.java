package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Operator;
import java.util.Optional;

public interface IOperatorService {
    Operator getOperatorById(int operatorId) throws OperatorNotFoundException;
    Operator addOperator(String name, String employeeId) throws OperatorCreationFailedException;
}
