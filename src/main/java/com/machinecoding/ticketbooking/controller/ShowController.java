package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.model.Movie;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Show;
import com.machinecoding.ticketbooking.service.MovieService;
import com.machinecoding.ticketbooking.service.SeatAvailablilityService;
import com.machinecoding.ticketbooking.service.ShowService;
import com.machinecoding.ticketbooking.service.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowController {
    private final SeatAvailablilityService seatAvailablilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public String createShow(
            @NonNull final String movieId,
            @NonNull final String screenId,
            @NonNull final Date startTime,
            @NonNull final Integer duration){
        Movie movie = movieService.getMovie(movieId);
        Screen screen = theatreService.getScreen(screenId);
        return showService.createShow(movie,startTime, duration,screen).getId();
    }

    public List<String> getAvailableSeats(@NonNull final String showId){
        Show show = showService.getShow(showId);
        List<Seat> availableSeats = seatAvailablilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
