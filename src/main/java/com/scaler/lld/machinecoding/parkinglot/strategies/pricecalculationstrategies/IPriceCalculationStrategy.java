package com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategies;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Date;

public interface IPriceCalculationStrategy {
    public int calculatePrice(Ticket ticket, Date exitTime);
}
