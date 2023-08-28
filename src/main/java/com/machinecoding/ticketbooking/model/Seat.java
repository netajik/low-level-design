package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Seat {

    private final String id;
    private final Integer rowNo;
    private final Integer seatNo;
}
