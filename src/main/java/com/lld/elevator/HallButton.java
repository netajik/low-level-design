package com.lld.elevator;

import com.lld.elevator.enums.Direction;

public class HallButton extends Button {
    int sourceFloorNumber;
    Direction buttonSign;

    @Override
    public void pressDown() {

    }

    @Override
    public boolean isPressed() {
        return false;
    }
}
