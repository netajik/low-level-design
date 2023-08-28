package com.machinecoding.parkinglot.service;

import com.machinecoding.parkinglot.model.ParkingFloor;
import com.machinecoding.parkinglot.model.ParkingLot;
import com.machinecoding.parkinglot.model.ParkingSpot;
import com.machinecoding.parkinglot.model.Vehicle;

import java.util.Map;

public class NearestAvailableSlotStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot getAvailableSpot(ParkingLot parkingLot, Vehicle vehicle) {
        for(Map.Entry<Integer, ParkingFloor> floor: parkingLot.getFloorMap().entrySet()){
            ParkingFloor parkingFloor = floor.getValue();
            if(parkingFloor.canPark(vehicle)){
               return parkingFloor.getAvailableSpot(vehicle);
            }
        }
        return null;
    }
}
