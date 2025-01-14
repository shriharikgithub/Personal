package com.scaler.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Shrihari
 */
@Getter
@Setter
@Entity (name = "seatz")
public class Seat extends BaseModel {

    private String seatNumber;

    @Column(name = "rowz")
    private int row;

    @Column (name = "colz")
    private int col;

    @ManyToOne
    private SeatType seatType; // one seat has one type, one type can have many seats
}
