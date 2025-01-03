package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Date;
import java.util.Map;
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
            return ticket;
        }
    }
}
