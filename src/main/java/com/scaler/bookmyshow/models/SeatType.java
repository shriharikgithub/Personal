package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Shrihari
 */
@Setter
@Getter
@Entity
public class SeatType extends BaseModel {
    String name;
}
