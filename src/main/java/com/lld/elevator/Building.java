package com.lld.elevator;

import java.util.List;

public class Building {

    private List<Floor> floor;
    private List<ElevatorCar> elevatorCar;

    private static Building building = null;

    public static Building getInstance(){
        if(building == null){
            return new Building();
        }
        return building;
    }
}
