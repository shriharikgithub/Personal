package com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategyfactory;

import com.scaler.lld.machinecoding.parkinglot.models.Ticket;
import com.scaler.lld.machinecoding.parkinglot.models.VehicleType;
import com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategies.BikePriceCalculationStrategy;
import com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategies.CarPriceCalculationStrategy;
import com.scaler.lld.machinecoding.parkinglot.strategies.pricecalculationstrategies.IPriceCalculationStrategy;

/**
 * Author: Shrihari
 */
public class IPriceCalculationStrategyFactory {
    public static IPriceCalculationStrategy getPriceCalculationStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case CAR -> new CarPriceCalculationStrategy();
            case BIKE -> new BikePriceCalculationStrategy();
            case SUV -> new CarPriceCalculationStrategy();
            case OTHERS -> new CarPriceCalculationStrategy();
        };
    }
}
