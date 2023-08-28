package com.machinecoding.ticketbooking.provider;

import com.machinecoding.ticketbooking.exception.SeatTemporarilyUnavailableException;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.SeatLock;
import com.machinecoding.ticketbooking.model.Show;
import lombok.NonNull;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySeatLockProvider implements SeatLockProvider{

    private final Integer lockTimeout; //Bonus Feature;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider(@NonNull final Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.locks = new HashMap<>();
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat : seats){
            if(isSeatLocked(show, seat)){
                throw new SeatTemporarilyUnavailableException();
            }
        }
        for(Seat seat: seats){
            lockSeat(show, seat, user, lockTimeout);
        }
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat: seats){
            if(validateLock(show,seat,user)){
                unlockSeat(show,seat);
            }
        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return locks.containsKey(show) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        return null;
    }

    private void unlockSeat(@NonNull Show show, @NonNull Seat seat){
        if(!locks.containsKey(show)){
            return;
        }
        locks.get(show).remove(seat);
    }
    private void lockSeat(
            @NonNull final Show show,
            @NonNull final Seat seat,
            @NonNull final String user,
            @NonNull final Integer timeoutInSeconds) {
        if(!locks.containsKey(show)){
            locks.put(show, new HashMap<>());
        }
        locks.get(show).put(seat,new SeatLock(seat, show,timeoutInSeconds,new Date(),user));
    }

    private boolean isSeatLocked(Show show, Seat seat){
        return locks.containsKey(show)
                && locks.get(show).containsKey(seat)
                && !locks.get(show).get(seat).isLockExpired();
    }
}
