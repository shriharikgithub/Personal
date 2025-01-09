package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Shrihari
 */
@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private String seatNumber;

    private int row;

    private int col;

    @ManyToOne
    private SeatType seatType; // one seat has one type, one type can have many seats
}
