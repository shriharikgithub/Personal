package com.scaler.lld.machinecoding.parkinglot.services;

import com.scaler.lld.machinecoding.parkinglot.exceptions.*;
import com.scaler.lld.machinecoding.parkinglot.models.Bill;

public interface IBillService {
    Bill createBill(int ticketId, String vehicleNumber, int gateId) throws VehicleNotFoundException, TicketNotFoundException, GateNotFoundException, ParkingSpotNotFoundException;
}
