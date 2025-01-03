package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Optional;

public interface ITicketRepository {

    Ticket save(Ticket ticket);

    Optional<Ticket> getTicketById(int ticketId);

    Optional<Ticket> getTicketByVehicleNumber(String vehicleNumber);
}
