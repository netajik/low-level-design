package com.machinecoding.parkinglot;

import com.machinecoding.parkinglot.model.ParkingLot;
import com.machinecoding.parkinglot.model.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bufferedReader.readLine().split(" ");
        ParkingLot parkingLot = ParkingLot.getInstance(str[0],Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        parkingLot.initializeParkingLot();

        outerloop:
        while(true){
            String[] cmd = bufferedReader.readLine().split(" ");
            switch (cmd[0]){
                case "create_parking_lot":
                    break;
                case "park_vehicle":
                    Vehicle vehicle = new Vehicle(cmd[1], cmd[2], cmd[3]);
                    parkingLot.parkVehicle(vehicle);
                    break;
                case "unpark_vehicle":
                    parkingLot.unParkVehicle(cmd[1]);
                    break;
                case "display":
                    break;
                case "exit":
                    break outerloop;
            }
        }
    }
}
