package com.scaler.lld.machinecoding.parkinglot.exceptions;

/**
 * Author: Shrihari
 */
public class GlobalExceptionHandler {
    public static String handleGateNotFoundException(GateNotFoundException e) {
        return "Error 404: Gate not found - " + e.getMessage();
    }

    public static String handleOperatorNotFoundException(OperatorNotFoundException e) {
        return "Error 404: Operator not found - " + e.getMessage();
    }

    public static String handleParkingLotNotFoundException(ParkingLotNotFoundException e) {
        return "Error 404: Parking Lot not found - " + e.getMessage();
    }

    public static String handleParkingLotCreationFailedException(ParkingLotCreationFailedException e) {
        return "Error 500: Parking lot creation failed - " + e.getMessage();
    }

    public static String handleGateCreationFailedException(GateCreationFailedException e) {
        return "Error 500: Gate creation failed - " + e.getMessage();
    }

    public static String handleOperatorCreationFailedException(OperatorCreationFailedException e) {
        return "Error 500: Operator creation failed - " + e.getMessage();
    }

    public static String handleParkingSpotNotFoundException(ParkingSpotNotFoundException e) {
        return "Error 404: Parking Spot not found - " + e.getMessage();
    }

    public static String handleParkingFloorNotFoundException(ParkingFloorNotFoundException e) {
        return "Error 404: Parking Floor not found - " + e.getMessage();
    }

    public static String handleParkingSpotCreationFailedException(ParkingSpotCreationFailedException e) {
        return "Error 500: Parking Spot creation failed - " + e.getMessage();
    }

    public static String handleVehicleNotFoundException(VehicleNotFoundException e) {
        return "Error 404: Vehicle not found - " + e.getMessage();
    }

    public static String handleTicketNotFoundException(TicketNotFoundException e) {
        return "Error 404: Ticket not found - " + e.getMessage();
    }
}
