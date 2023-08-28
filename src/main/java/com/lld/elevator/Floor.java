package com.lld.elevator;

import java.util.List;

public class Floor {
    private List<Display> display;
    private HallPannel hallPannel;

    public boolean isBottomMost() {
        return false;
    }

    public boolean isTopMost() {
        return false;
    }
}
