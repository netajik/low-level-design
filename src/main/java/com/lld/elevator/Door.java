package com.lld.elevator;

import com.lld.elevator.enums.DoorState;

public class Door {
    private DoorState state;

    public boolean isOpen() {
        return state == DoorState.OPEN;
    }
}
