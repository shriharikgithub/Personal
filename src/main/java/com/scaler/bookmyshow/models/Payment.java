package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: Shrihari
 */
@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider provider;

    private Date time;

    private String referenceId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @ManyToOne
    private Ticket ticket;
}
