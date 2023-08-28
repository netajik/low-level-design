package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.exception.BadRequestException;
import com.machinecoding.ticketbooking.model.Booking;
import com.machinecoding.ticketbooking.provider.SeatLockProvider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;
    private final SeatLockProvider seatLockProvider;

    public PaymentService(@NonNull final Integer allowedRetries, SeatLockProvider seatLockProvider) {
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
        this.bookingFailures = new HashMap<>();
    }

    public void processPaymentFailed(@NonNull final Booking booking, @NonNull final String user) {
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        if(!bookingFailures.containsKey(booking)){
            bookingFailures.put(booking,0);
        }
        final Integer currentFailureCount = bookingFailures.get(booking);
        final Integer newFailureCount = currentFailureCount+1;
        bookingFailures.put(booking, newFailureCount);
        if(newFailureCount>allowedRetries){
            seatLockProvider.unlockSeats(booking.getShow(),booking.getSeatList(),user);
        }
    }
}
