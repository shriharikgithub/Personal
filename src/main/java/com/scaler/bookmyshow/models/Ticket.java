package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;
}
