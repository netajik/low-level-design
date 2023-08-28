package com.machinecoding.parkinglot.model;

import com.machinecoding.parkinglot.enums.ParkingSpotType;
import com.machinecoding.parkinglot.enums.VehicleType;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingFloor {

    private Integer floorId;

    private Map<ParkingSpotType, Map<Integer, ParkingSpot>> availableSpots;

    private Map<ParkingSpotType,Map<Integer, ParkingSpot>> occupiedSpots;

    private Map<Integer,ParkingSpot> spotMap;

    public ParkingFloor(Integer floorId){
        this.floorId = floorId;
        spotMap = new HashMap<>();

        availableSpots = new HashMap<>();
        availableSpots.put(ParkingSpotType.BIKE, new HashMap<>());
        availableSpots.put(ParkingSpotType.CAR, new HashMap<>());
        availableSpots.put(ParkingSpotType.TRUCK, new HashMap<>());

        occupiedSpots = new HashMap<>();
        occupiedSpots.put(ParkingSpotType.BIKE, new HashMap<>());
        occupiedSpots.put(ParkingSpotType.CAR, new HashMap<>());
        occupiedSpots.put(ParkingSpotType.TRUCK, new HashMap<>());
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        availableSpots.get(parkingSpot.getParkingSpotType()).put(parkingSpot.getParkingSpotId(),parkingSpot);
        spotMap.put(parkingSpot.getParkingSpotId(),parkingSpot);
    }

    ParkingSpotType getParkingSpotTypeForVehicle(VehicleType vehicleType){
        switch (vehicleType){
            case BIKE:
                return ParkingSpotType.BIKE;
            case CAR:
                return ParkingSpotType.CAR;
            default:
                return ParkingSpotType.TRUCK;
        }
    }

    public boolean canPark(Vehicle vehicle){
        ParkingSpotType parkingSpotType = getParkingSpotTypeForVehicle(vehicle.getVehicleType());
        return availableSpots.get(parkingSpotType).size()>0;
    }

    public ParkingSpot getAvailableSpot(Vehicle vehicle){
        ParkingSpotType parkingSpotType = getParkingSpotTypeForVehicle(vehicle.getVehicleType());
        for(Map.Entry<Integer, ParkingSpot> parkingSpot: availableSpots.get(parkingSpotType).entrySet()){
            return parkingSpot.getValue();
        }
        return null;
    }

    public void moveSpotFromAvailableMapToOccupiedMap(ParkingSpot parkingSpot){
        this.availableSpots.get(parkingSpot.getParkingSpotType()).remove(parkingSpot.getParkingSpotId());
        this.occupiedSpots.get(parkingSpot.getParkingSpotType()).put(parkingSpot.getParkingSpotId(),parkingSpot);
    }
}
