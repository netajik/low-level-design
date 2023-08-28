package com.machinecoding.parkinglot.service;

import com.machinecoding.parkinglot.model.ParkingLot;
import com.machinecoding.parkinglot.model.ParkingSpot;
import com.machinecoding.parkinglot.model.Vehicle;

public interface ParkingStrategy {
    ParkingSpot getAvailableSpot(ParkingLot parkingLot, Vehicle vehicle);
}
