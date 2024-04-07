package com.machinecoding.cabbooking.database;

import java.util.HashMap;
import java.util.Map;

import com.machinecoding.cabbooking.model.Rider;

import lombok.NonNull;

/** In memory database for storing jobs. */
public class RiderManager {
    
    Map<String, Rider> riders = new HashMap<>();
    
    public void createRider(@NonNull final Rider newRider) {}

    public Rider getRider(@NonNull final String riderId){ return null;}
}
