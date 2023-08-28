package com.lld.meetingscheduler;

import java.util.List;

public class MeetingRoom {

    private int id;
    private int capacity;
    private List<MeetingInterval> bookedIntervals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<MeetingInterval> getBookedIntervals() {
        return bookedIntervals;
    }

    public void setBookedIntervals(List<MeetingInterval> bookedIntervals) {
        this.bookedIntervals = bookedIntervals;
    }

    boolean isAvailable() {
        return true;
    }
}
