package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

public interface ITicketRepository {

    Ticket save(Ticket ticket);
}
