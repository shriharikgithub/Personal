package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Author: Shrihari
 */
@Getter
@Setter
@Entity
public class Ticket extends BaseModel {

    private int amount;

    private Date timeOfBooking;

    @ManyToMany
    private List<Seat> seats;

    @ManyToOne
    private User bookedBy;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<Payment> payments;

    private TicketStatus status;
}
