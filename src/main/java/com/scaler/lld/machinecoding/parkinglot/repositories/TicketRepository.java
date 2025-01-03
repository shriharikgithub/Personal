package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class TicketRepository implements ITicketRepository {

    private Map<Integer, Ticket> ticketMap;
    private int lastSaveId;

    public TicketRepository() {
        this.ticketMap = new TreeMap<>();
        lastSaveId = 0;
    }

    @Override
    public Ticket save(Ticket ticket) {
        if (ticketMap.containsKey(ticket.getId())) {
            ticket = ticketMap.get(ticket.getId());
            ticket.setUpdatedAt(new Date());
            return ticket;
        } else {
            ticketMap.put(++lastSaveId, ticket);
            ticket.setId(lastSaveId);
            ticket.setCreatedAt(new Date());
            ticket.setUpdatedAt(new Date());
            return ticket;
        }
    }

    @Override
    public Optional<Ticket> getTicketById(int ticketId) {
        if (ticketMap.containsKey(ticketId)) {
            return Optional.of(ticketMap.get(ticketId));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Ticket> getTicketByVehicleNumber(String vehicleNumber) {
        return ticketMap
                .values()
                .stream()
                .filter(t -> t.getVehicle().getVehicleNumber().equalsIgnoreCase(vehicleNumber))
                .findFirst();
    }
}
