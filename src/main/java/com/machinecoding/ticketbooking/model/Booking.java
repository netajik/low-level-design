package com.machinecoding.ticketbooking.model;

import com.machinecoding.ticketbooking.exception.BadRequestException;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Booking {

    private String id;
    private List<Seat> seatList;
    private Show show;
    private String user;
    private BookingStatus bookingStatus;

    public Booking(@NonNull final String id, @NonNull final Show show, @NonNull final String user) {
        this.id = id;
        this.show = show;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public Boolean isConfirmed() {
        return this.bookingStatus==BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if(this.bookingStatus != BookingStatus.CREATED){
            throw new BadRequestException();
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if(this.bookingStatus != BookingStatus.CREATED){

        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }
}
