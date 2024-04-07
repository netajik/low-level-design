package com.machinecoding.cabbooking.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.machinecoding.cabbooking.model.Cab;
import com.machinecoding.cabbooking.model.Location;
import com.machinecoding.cabbooking.model.Rider;
import com.machinecoding.cabbooking.model.Trip;

import lombok.NonNull;

public class TripManager {
    
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    Map<String, List<Trip>> trips = new HashMap<>();

    public void createTrip(
        @NonNull final Rider rider,
        @NonNull final Location fromPoint,
        @NonNull final Location toPoint) {}

    public List<Trip> tripHistory(@NonNull final String riderId) {return null;}

    public void endTrip(@NonNull final Cab cab){}
}
