package com.machinecoding.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Show {

    private final String id;
    private final Movie movie;
    private final Date startDate;
    private final Integer duration;
    private final Screen screen;
}
