package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.OperatorNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotCreationFailedException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.Ticket;
import com.scaler.lld.machinecoding.parkinglot.models.Vehicle;

import java.util.Optional;

public interface ITicketService {
    Ticket generateTicket(Vehicle vehicle, Gate gate) throws ParkingLotNotFoundException, OperatorNotFoundException, ParkingSpotNotFoundException;

    Optional<Ticket> getTicketById(int ticketId);

    Optional<Ticket> getTicketByVehicleNumber(String vehicleNumber);
}
