package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    public String createMovie(@NonNull final String movieName){
        return movieService.createMovie(movieName).getId();
    }
}
