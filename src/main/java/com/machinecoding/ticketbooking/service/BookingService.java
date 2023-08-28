package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.provider.SeatLockProvider;
import com.machinecoding.ticketbooking.exception.BadRequestException;
import com.machinecoding.ticketbooking.exception.NotFoundException;
import com.machinecoding.ticketbooking.exception.SeatPermanentlyUnavailableException;
import com.machinecoding.ticketbooking.model.Booking;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private final Map<String, Booking> showBookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(@NonNull final SeatLockProvider seatLockProvider){
        this.showBookings = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public Booking getBooking(@NonNull final String bookingId){
        if(!showBookings.containsKey(bookingId)){
            throw new NotFoundException();
        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBooking(@NonNull final Show show){
        List<Booking> response = new ArrayList<>();
        for(Booking booking: showBookings.values()){
            if(show.equals(booking.getShow())){
                response.add(booking);
            }
        }
        return response;
    }

    public Booking createBooking(
            @NonNull final String userId,
            @NonNull final Show show,
            @NonNull final List<Seat> seats){
        if(isAnySeatAlreadyBooked(show,seats)){
            throw new SeatPermanentlyUnavailableException();
        }

        seatLockProvider.lockSeats(show, seats,userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingId,show,userId);
        showBookings.put(bookingId, newBooking);
        return newBooking;
        // TODO: Create timer for booking expiry
    }

    public List<Seat> getBookedSeats(@NonNull final Show show) {
        return getAllBooking(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public void confirmBooking(@NonNull final Booking booking, @NonNull final String user){
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }

        for(Seat seat: booking.getSeatList()){
            if(!seatLockProvider.validateLock(booking.getShow(),seat,user)){
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }

    private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show);
        for(Seat seat: bookedSeats){
            if(seats.contains(seat)){
                return true;
            }
        }
        return false;
    }
}
