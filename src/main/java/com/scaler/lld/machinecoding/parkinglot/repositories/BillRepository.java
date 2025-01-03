package com.scaler.lld.machinecoding.parkinglot.repositories;

import com.scaler.lld.machinecoding.parkinglot.models.Bill;
import com.scaler.lld.machinecoding.parkinglot.models.Gate;
import com.scaler.lld.machinecoding.parkinglot.models.Operator;
import com.scaler.lld.machinecoding.parkinglot.models.Ticket;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author: Shrihari
 */
public class BillRepository implements IBillRepository {
    private Map<Integer, Bill> billMap;
    private int lastSaveId;

    public BillRepository() {
        this.billMap = new TreeMap<>();
        this.lastSaveId = 0;
    }

    @Override
    public Bill save(Ticket ticket, Date exitTime, Gate gate, int price, String url) {
        Bill bill = new Bill();
        bill.setAmount(price);
        bill.setGate(gate);
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);
        bill.setOnlinePaymentLink(url);
        bill.setCreatedAt(new Date());
        bill.setUpdatedAt(new Date());
        bill.setId(++lastSaveId);
        billMap.put(lastSaveId, bill);
        return billMap.get(lastSaveId);
    }
}
