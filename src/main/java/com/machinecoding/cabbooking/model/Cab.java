package com.machinecoding.cabbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cab {
    private String id;
    private String driverName;

    @Setter Trip currTrip;
    @Setter Location currLocation;
    @Setter Boolean isAvailable;
}
