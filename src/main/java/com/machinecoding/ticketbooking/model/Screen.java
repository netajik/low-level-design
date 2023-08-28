package com.machinecoding.ticketbooking.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Screen {

    private String id;
    private String name;
    private Theatre theatre;
    private List<Seat> seatList;

    public Screen(@NonNull final String id, @NonNull final String name,@NonNull Theatre theatre){
        this.id = id;
        this.name = name;
        this.theatre = theatre;
    }

    public void addSeat(@NonNull final Seat seat){
        seatList.add(seat);
    }
}
