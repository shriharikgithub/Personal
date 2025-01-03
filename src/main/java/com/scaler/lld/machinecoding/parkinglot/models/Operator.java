package com.scaler.lld.machinecoding.parkinglot.models;

public class Operator extends BaseModel {

    private String name;
    private String employeeID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}
