package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
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
public class Show extends BaseModel {

    @ManyToOne
    private Auditorium auditorium;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    private Language language;
}
