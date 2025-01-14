package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Shrihari
 */
@Getter
@Setter
public class BookTicketResponseDto {
    private ResponseStatus responseStatus;
    private String errorMessage;
}
