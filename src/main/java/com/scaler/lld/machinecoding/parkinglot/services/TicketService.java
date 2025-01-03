package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingLotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.scaler.lld.machinecoding.parkinglot.models.*;
import com.scaler.lld.machinecoding.parkinglot.repositories.ITicketRepository;
import com.scaler.lld.machinecoding.parkinglot.strategies.spotassignmentstrategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

/**
 * Author: Shrihari
 */
public class TicketService implements ITicketService {

    private ITicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private IParkingLotService parkingLotService;
    private IParkingSpotService parkingSpotService;

    public TicketService(ITicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         IParkingLotService parkingLotService,
                         IOperatorService operatorService,
                         IParkingSpotService parkingSpotService) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public Ticket generateTicket(Vehicle vehicle, Gate gate) throws ParkingLotNotFoundException, ParkingSpotNotFoundException {

        Ticket ticket = new Ticket();
        ParkingLot parkingLot = parkingLotService.getParkingLotByGateId(gate.getId());
        Optional<ParkingSpot> optionalParkingSpot = spotAssignmentStrategy.findSpot(parkingLot, vehicle.getVehicleType());
        ParkingSpot parkingSpot;

        if (optionalParkingSpot.isEmpty()) {
            throw new ParkingSpotNotFoundException();
        } else {
            parkingSpot = optionalParkingSpot.get();
            parkingSpot.setParkingSpotStatus(ParkingSpotStatus.FILLED);
            parkingSpot = parkingSpotService.update(parkingSpot);
        }

        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getCurrentOperator());
        ticket = ticketRepository.save(ticket);

        return ticket;
    }

    @Override
    public Optional<Ticket> getTicketById(int ticketId) {
        return ticketRepository.getTicketById(ticketId);
    }

    @Override
    public Optional<Ticket> getTicketByVehicleNumber(String vehicleNumber) {
        return ticketRepository.getTicketByVehicleNumber(vehicleNumber);
    }
}
