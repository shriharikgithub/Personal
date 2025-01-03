package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Bill;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Date;

/**
 * Author: Shrihari
 */
public interface IBillRepository {
    Bill save(Ticket ticket, Date exitTime, Gate gate, int price, String url);
}
