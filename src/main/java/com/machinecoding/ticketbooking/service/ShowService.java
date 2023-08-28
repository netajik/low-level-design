package com.machinecoding.ticketbooking.service;

import com.machinecoding.ticketbooking.exception.NotFoundException;
import com.machinecoding.ticketbooking.exception.ScreenAlreadyOccupiedException;
import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Show;
import lombok.NonNull;

import java.util.*;


public class ShowService {
    private final Map<String, Show> showMap;

    public ShowService(){
        this.showMap = new HashMap<>();
    }

    public Show getShow(@NonNull final String showId){
        if(!this.showMap.containsKey(showId)){
            throw new NotFoundException();
        }
        return this.showMap.get(showId);
    }

    public Show createShow(
            @NonNull final Movie movie,
            @NonNull final Date startDate,
            @NonNull final Integer duration,
            @NonNull final Screen screen){
        if(!checkIfShowCreattionAllowed(screen,startDate,duration)) {
            throw new ScreenAlreadyOccupiedException();
        }
        String showId = UUID.randomUUID().toString();
        Show show = new Show(showId,movie, startDate,duration,screen);
        this.showMap.putIfAbsent(showId, show);
        return show;
    }

    public List<Show> getShowsForScreen(@NonNull final Screen screen) {
        final List<Show> response = new ArrayList<>();
        for(Show show: showMap.values()){
            if(show.getScreen().equals(screen)){
                response.add(show);
            }
        }
        return response;
    }

    boolean checkIfShowCreattionAllowed(final Screen screen, final Date startDate, final Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }
}
