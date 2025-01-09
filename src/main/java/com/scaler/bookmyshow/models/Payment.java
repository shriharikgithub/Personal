package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
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
    private PaymentProvider provider;
    private Date time;
    private String referenceId;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
}
