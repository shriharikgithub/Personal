package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: Shrihari
 */
@Getter
@Setter
@Entity
public class Movie extends BaseModel {

    private List<Language> languages;
}
