package com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategies;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Date;

/**
 * Author: Shrihari
 */
public class BikePriceCalculationStrategy implements IPriceCalculationStrategy {

    private int basePrice = 10;

    @Override
    public int calculatePrice(Ticket ticket, Date exitTime) {
        Date entryTime = ticket.getEntryTime();
        long difference = exitTime.getTime() - entryTime.getTime();
        return (int)(difference * basePrice);
    }
}
