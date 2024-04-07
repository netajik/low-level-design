package com.machinecoding.cabbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Location {
    
    private Double x;
    private Double y;

    public Double distance(Location location2) {
        return Math.sqrt((Math.pow(this.x-location2.x,2) + Math.pow(this.y-location2.y,2)));
    }
}
