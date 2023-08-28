package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.exception.NotFoundException;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Seat;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private final Map<String, Theatre> theatreMap;
    private final Map<String, Screen> screenMap;
    private final Map<String, Seat> seatMap;

    public TheatreService(){
        this.theatreMap = new HashMap<>();
        this.screenMap = new HashMap<>();
        this.seatMap = new HashMap<>();
    }

    public Theatre createTheatre(@NonNull final String theatreName) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theatreName);
        theatreMap.put(theatreId, theatre);
        return theatre;
    }

    public Theatre getTheatre(@NonNull final String theatreId){
        if(!theatreMap.containsKey(theatreId)){
            throw new NotFoundException();
        }
        return theatreMap.get(theatreId);
    }

    public Screen createScreenInTheatre(@NonNull final String screenName, @NonNull final Theatre theatre) {
        Screen screen = createScreen(screenName,theatre);
        theatre.addScreen(screen);
        return screen;
    }

    public Screen createScreen(@NonNull final String screenName, @NonNull final Theatre theatre){
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId,screenName,theatre);
        screenMap.put(screenId, screen);
        return screen;
    }

    public Screen getScreen(@NonNull final String screenId){
        if(!screenMap.containsKey(screenId)){
            throw new NotFoundException();
        }
        return screenMap.get(screenId);
    }

    public Seat createSeatInScreen(@NonNull final Integer rowNo, @NonNull final Integer seatNo, @NonNull final Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId,rowNo, seatNo);
        screen.addSeat(seat);
        seatMap.put(seatId, seat);
        return seat;
    }

    public Seat getSeat(@NonNull final String seatId){
        if(!seatMap.containsKey(seatId)){
            throw new NotFoundException();
        }
        return seatMap.get(seatId);
    }
}
