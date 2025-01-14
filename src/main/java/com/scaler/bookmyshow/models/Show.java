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
@Entity (name = "showz")
public class Show extends BaseModel {

    @ManyToOne
    private Auditorium auditorium;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    private Language language;
}
