package com.lld.elevator;

public class ElevatorSystem {
    private Building building;

    public void monitoring() {
    }

    public void dispatcher() {
    }

    // The ElevarSystem is a singleton class that ensures it will have only one
    // active instance at a time
    private static ElevatorSystem elevatorSystem = null;

    // Created a static method to access the singleton instance of ElevatorSytem
    // class
    public static ElevatorSystem getInstance() {
        if (elevatorSystem == null) {
            return new ElevatorSystem();
        }
        return elevatorSystem;
    }
}
