package com.machinecoding.cabbooking.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.machinecoding.cabbooking.model.Cab;
import com.machinecoding.cabbooking.model.Location;

import lombok.NonNull;

public class CabManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void createCab(@NonNull final Cab newCab){}

    public Cab getCab(@NonNull final String cabId) {return null;}

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {}

    public void updateCabAvailability(
        @NonNull final String cabId, @NonNull final Boolean newAvailability) {}

    public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance) {return null;}
    
}
