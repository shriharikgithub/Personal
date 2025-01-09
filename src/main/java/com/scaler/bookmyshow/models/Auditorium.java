package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: Shrihari
 */
@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {

    private String name;

    @OneToMany
    private List<Seat> seats;

    private List<Feature> features;
}
