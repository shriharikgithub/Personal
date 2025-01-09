package com.scaler.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

/**
 * Author: Shrihari
 */
@MappedSuperclass // Dont create a separate table, every class will have id attribute.
public class BaseModel {
    @Id
    private Long id;
    private Date createdDate;
    private Date lastModifiedAt;
}
