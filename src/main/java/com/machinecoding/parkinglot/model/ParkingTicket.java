package com.machinecoding.parkinglot.model;

import lombok.Getter;

@Getter
public class ParkingTicket {

    private String ticketId;

    private Integer floorId;

    private Integer spotId;

    public ParkingTicket(String ticketId, Integer floorId, Integer spotId){
        this.ticketId = ticketId;
        this.floorId = floorId;
        this.spotId = spotId;
    }
}
