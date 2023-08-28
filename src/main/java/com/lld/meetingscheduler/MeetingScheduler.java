package com.lld.meetingscheduler;

import java.util.List;

public class MeetingScheduler {
    private MeetingUser organizer;
    private MeetingCalender meetingCalender;
    private List<MeetingRoom> roomList;

    // Scheduler is a singleton class that ensures it will have only one active instance at a time
    private static final MeetingScheduler meetingScheduler = null;

    // Created a static method to access the singleton instance of Scheduler class
    static MeetingScheduler getInstance(){
        if(meetingScheduler != null){
            return meetingScheduler;
        }
        return new MeetingScheduler();
    }

    public MeetingUser getOrganizer() {
        return organizer;
    }

    public void setOrganizer(MeetingUser organizer) {
        this.organizer = organizer;
    }

    public MeetingCalender getMeetingCalender() {
        return meetingCalender;
    }

    public void setMeetingCalender(MeetingCalender meetingCalender) {
        this.meetingCalender = meetingCalender;
    }

    public List<MeetingRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<MeetingRoom> roomList) {
        this.roomList = roomList;
    }

    public boolean scheduleMeeting(List<MeetingUser> userList,MeetingInterval meetingInterval){
        return true;
    }

    public boolean cancelMeeting(List<MeetingUser> userList, MeetingInterval meetingInterval){
        return true;
    }

    public boolean bookRoom(MeetingRoom meetingRoom,MeetingInterval meetingInterval){
       return true;
    }

    public boolean releaseRoom(MeetingRoom meetingRoom, MeetingInterval meetingInterval){
        return true;
    }

    public MeetingRoom checkRoomsAvailability(int usersCount,MeetingInterval meetingInterval){
        return null;
    }
}
