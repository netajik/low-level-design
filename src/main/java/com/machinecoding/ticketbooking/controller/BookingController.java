package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.service.BookingService;
import com.machinecoding.ticketbooking.service.ShowService;
import com.machinecoding.ticketbooking.service.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ShowService showService;
    private final TheatreService theatreService;

    public String createBooking(
            @NonNull final String userId,
            @NonNull String showId,
            @NonNull final List<String> seatIds){
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
