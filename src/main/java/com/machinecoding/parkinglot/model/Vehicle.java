package com.machinecoding.parkinglot.model;

import com.machinecoding.parkinglot.enums.VehicleType;
import lombok.Getter;

@Getter
public class Vehicle {

    private VehicleType vehicleType;
    private String registrationNumber;
    private String color;
    private ParkingTicket parkingTicket;

    public Vehicle(String type, String registrationNumber, String color){
        switch (type){
            case "CAR":
                this.vehicleType = VehicleType.CAR;
                break;
            case "BIKE":
                this.vehicleType = VehicleType.BIKE;
                break;
            case "TRUCK":
                this.vehicleType = VehicleType.TRUCK;
                break;
        }
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public void assignTicket(ParkingTicket parkingTicket){
        this.parkingTicket = parkingTicket;
        System.out.println("Parked Vehicle. Ticket ID "+parkingTicket.getTicketId());
    }
}
