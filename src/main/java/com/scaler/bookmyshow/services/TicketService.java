package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.InvalidArgumentsException;
import com.scaler.bookmyshow.exceptions.SeatsNotAvailableException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Author: Shrihari
 */
@Service
public class TicketService {

    private final UserRepository userRepository;

    private final ShowRepository showRepository;

    private final ShowSeatRepository showSeatRepository;

    private final TicketRepository ticketRepository;

    private final SeatRepository seatRepository;

    @Autowired
    public TicketService(UserRepository userRepository,
                         ShowRepository showRepository,
                         ShowSeatRepository showSeatRepository,
                         TicketRepository ticketRepository,
                         SeatRepository seatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional (propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, Long showId, List<Long> seatIds) throws InvalidArgumentsException, SeatsNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new InvalidArgumentsException("User with : " + userId + " doesn't exist.");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new InvalidArgumentsException("Show with : " + showId + " doesn't exist.");
        }

        Show show = optionalShow.get();

        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);

        try {
            List<ShowSeat> showSeats = getAndLockShowSeats(seats, show);
        } catch (TransactionTimedOutException e) {
            throw new SeatsNotAvailableException();
        }


        Ticket ticket = new Ticket();
        ticket.setBookedBy(user);
        ticket.setShow(show);
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setStatus(TicketStatus.PROCESSING);
        ticket.setTimeOfBooking(new Date());
        return ticketRepository.save(ticket);
    }

    @Transactional (propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> getAndLockShowSeats(List<Seat> seats, Show show) throws SeatsNotAvailableException {

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, show);

        boolean hasUnavailableSeat = showSeats
                .stream()
                .anyMatch(s -> !s.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                        (s.getShowSeatStatus().equals(ShowSeatStatus.LOCKED) && s.getLockedAt().getTime() < (System.currentTimeMillis() - (15 * 60 * 1000))));

        if (hasUnavailableSeat) {
            throw new SeatsNotAvailableException();
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        return savedShowSeats;
    }


}
