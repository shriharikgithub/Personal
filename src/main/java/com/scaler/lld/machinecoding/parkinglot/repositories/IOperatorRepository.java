package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Operator;

import java.util.Optional;

public interface IOperatorRepository {
    Optional<Operator> getOperatorById(int operatorId);

    Operator save(String name, String employeeId);
}
