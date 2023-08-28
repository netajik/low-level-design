package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.service.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class TheatreController {
    private TheatreService theatreService;

    String createTheatre(@NonNull final String theatreName){
        return theatreService.createTheatre(theatreName).getId();
    }

    String createScreenInTheatre(@NonNull final String screenName, @NonNull final Theatre theatre){
        return theatreService.createScreen(screenName, theatre).getId();
    }

    String createSeat(@NonNull final Integer rowNo, @NonNull Integer seatNo, @NonNull final Screen screen){
        return theatreService.createSeatInScreen(rowNo,seatNo,screen).getId();
    }
}
