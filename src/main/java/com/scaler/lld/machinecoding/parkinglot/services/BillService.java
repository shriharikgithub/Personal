package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.*;
import com.scaler.lld.machinecoding.parkinglot.models.*;
import com.scaler.lld.machinecoding.parkinglot.repositories.IBillRepository;
import com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategies.IPriceCalculationStrategy;
import com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategyfactory.IPriceCalculationStrategyFactory;

import java.util.Date;
import java.util.Optional;

/**
 * Author: Shrihari
 */
public class BillService implements IBillService {

    private ITicketService ticketService;
    private IBillRepository billRepository;
    private IGateService gateService;
    private IParkingSpotService parkingSpotService;

    public BillService(ITicketService ticketService, IBillRepository billRepository,
                       IGateService gateService,
                       IParkingSpotService parkingSpotService) {
        this.ticketService = ticketService;
        this.billRepository = billRepository;
        this.gateService = gateService;
        this.parkingSpotService = parkingSpotService;
    }
    @Override
    public Bill createBill(int ticketId, String vehicleNumber, int gateId) throws TicketNotFoundException, GateNotFoundException, ParkingSpotNotFoundException {
        Optional<Ticket> optionalTicket = ticketService.getTicketById(ticketId);
        Ticket ticket = null;
        if (optionalTicket.isEmpty()) {
            optionalTicket = ticketService.getTicketByVehicleNumber(vehicleNumber);
            if (optionalTicket.isEmpty()) {
                throw new TicketNotFoundException();
            } else {
                ticket = optionalTicket.get();
            }
        } else {
            ticket = optionalTicket.get();
        }
        IPriceCalculationStrategy priceCalculationStrategy = IPriceCalculationStrategyFactory.getPriceCalculationStrategy(ticket.getVehicle().getVehicleType());
        Date exitTime = new Date();
        int price = priceCalculationStrategy.calculatePrice(ticket, exitTime);
        Gate gate = gateService.getGateByID(gateId);
        Bill bill = billRepository.save(ticket, exitTime, gate, price, "http://securepay/bill/");
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpot.setVehicle(null);
        parkingSpotService.update(parkingSpot);
        return bill;
    }
}
