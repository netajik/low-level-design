package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.provider.SeatLockProvider;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailablilityService {

    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public SeatAvailablilityService(
            @NonNull final BookingService bookingService,
            @NonNull final SeatLockProvider seatLockProvider
    ){
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(@NonNull final Show show){
        List<Seat> unavailableSeats = getUnavailableSeats(show);
        List<Seat> totalShowSeats = show.getScreen().getSeatList();
        List<Seat> availableSeats = new ArrayList<>(totalShowSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    public List<Seat> getUnavailableSeats(@NonNull final Show show){
        List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }
}
