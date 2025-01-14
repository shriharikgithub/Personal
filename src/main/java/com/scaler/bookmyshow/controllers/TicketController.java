package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.dtos.ResponseStatus;
import com.scaler.bookmyshow.exceptions.InvalidArgumentsException;
import com.scaler.bookmyshow.exceptions.SeatsNotAvailableException;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: Shrihari
 */
@Controller
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        try {
            Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getUserId(), bookTicketRequestDto.getShowId(), bookTicketRequestDto.getSeatIds());
        } catch (InvalidArgumentsException e) {
            bookTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            bookTicketResponseDto.setErrorMessage(e.getMessage());
        } catch (SeatsNotAvailableException e) {
            bookTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            bookTicketResponseDto.setErrorMessage("Seats are unavailable for booking.");
        }
        return bookTicketResponseDto;
    }
}
