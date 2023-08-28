package com.machinecoding.parkinglot.model;

import com.machinecoding.parkinglot.enums.ParkingSpotType;
import com.machinecoding.parkinglot.service.NearestAvailableSlotStrategy;
import com.machinecoding.parkinglot.service.ParkingStrategy;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
public class ParkingLot {

    private String parkingLotId;

    private Integer noOfFloors;

    private Integer noOfSpotsPerFloor;

    private Map<Integer, ParkingFloor> floorMap;
    private Map<String, ParkingTicket> ticketMap;
    private ParkingStrategy parkingStrategy;

    public static final Integer RESEVRED_SLOT_FOR_TRUCK = 1;
    public static final List<Integer> RESEVRED_SLOT_FOR_BIKE = Arrays.asList(2,3);

    static ParkingLot parkingLot = null;
    private ParkingLot(String parkingLotId, Integer noOfFloors, Integer noOfSpotsPerFloor){
        this.parkingLotId = parkingLotId;
        this.noOfFloors = noOfFloors;
        this.noOfSpotsPerFloor = noOfSpotsPerFloor;
        this.parkingStrategy = new NearestAvailableSlotStrategy();
    }

    public static ParkingLot getInstance(String parkingLotIt, Integer noOfFloors, Integer noOfSpotsPerFloor) {
        if(parkingLot == null){
            parkingLot = new ParkingLot(parkingLotIt, noOfFloors, noOfSpotsPerFloor);
        }
        return parkingLot;
    }

    public void initializeParkingLot(){
        for(int floorId=1;floorId<=noOfFloors;floorId++){
            ParkingFloor parkingFloor = new ParkingFloor(floorId);
            for(int spot=1;spot<=this.noOfSpotsPerFloor;spot++){
                ParkingSpotType parkingSpotType;
                if(spot == RESEVRED_SLOT_FOR_TRUCK) {
                    parkingSpotType = ParkingSpotType.TRUCK;
                } else if(RESEVRED_SLOT_FOR_BIKE.contains(spot)) {
                    parkingSpotType = ParkingSpotType.BIKE;
                } else {
                    parkingSpotType = ParkingSpotType.CAR;
                }
                ParkingSpot parkingSpot = new ParkingSpot(spot,parkingSpotType,floorId);
                addSpot(floorId,parkingSpot);
            }
            addFloor(parkingFloor);
        }
        System.out.println("Created parking lot with "+this.noOfFloors+" floors and "+this.noOfSpotsPerFloor+" slots per floor");
    }

    void addFloor(ParkingFloor parkingFloor){
        floorMap.put(parkingFloor.getFloorId(), parkingFloor);
    }

    void addSpot(Integer floorId, ParkingSpot parkingSpot){
        ParkingFloor parkingFloor = floorMap.get(floorId);
        parkingFloor.addParkingSpot(parkingSpot);
    }

    public ParkingTicket generateParkingTicket(String parkingLotId, Integer floorId, Integer spotId){
        String id = parkingLotId+"_"+floorId+"_"+spotId;
        return new ParkingTicket(id, floorId,spotId);
    }

    public void parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingStrategy.getAvailableSpot(this, vehicle);
        if(parkingSpot == null){
            System.out.println("parking lot full");
            return;
        }
        ParkingTicket parkingTicket = generateParkingTicket(this.getParkingLotId(),parkingSpot.getFloorId(), parkingSpot.getParkingSpotId());
        parkingSpot.assignVehicle(vehicle);
        ParkingFloor parkingFloor = floorMap.get(parkingSpot.getFloorId());
        ticketMap.put(parkingTicket.getTicketId(),parkingTicket);
        return;
    }

    public void unParkVehicle(String ticketId){
        ParkingTicket parkingTicket = ticketMap.get(ticketId);
        //ParkingSpot parkingSpot = parkingStrategy.getAvailableSpot(this, vehicle);
//        if(parkingSpot == null){
//            System.out.println("parking lot full");
//            return;
//        }
        //ParkingTicket parkingTicket = generateParkingTicket(this.getParkingLotId(),parkingSpot.getFloorId(), parkingSpot.getParkingSpotId());
        //parkingSpot.assignVehicle(vehicle);
        //ParkingFloor parkingFloor = floorMap.get(parkingSpot.getFloorId());
        ticketMap.put(parkingTicket.getTicketId(),parkingTicket);
        return;
    }
}
