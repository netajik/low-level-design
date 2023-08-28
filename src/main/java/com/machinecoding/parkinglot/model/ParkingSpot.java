package com.machinecoding.parkinglot.model;

import com.machinecoding.parkinglot.enums.ParkingSpotType;
import lombok.Getter;

@Getter
public class ParkingSpot {

    private Integer parkingSpotId;
    private ParkingSpotType parkingSpotType;
    private Integer floorId;
    private Vehicle vehicle;
    private boolean isSpotFree;

    public ParkingSpot(Integer parkingSpotId, ParkingSpotType parkingSpotType, Integer floorId){
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.floorId = floorId;
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isSpotFree = false;
    }
}
