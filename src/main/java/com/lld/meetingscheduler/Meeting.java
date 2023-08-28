package com.lld.meetingscheduler;

import java.util.List;

public class Meeting {
    private int id;
    private List<MeetingUser> userList;
    private MeetingInterval interval;
    private MeetingRoom meetingRoom;
    private String subject;
    private int participantsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MeetingUser> getUserList() {
        return userList;
    }

    public void setUserList(List<MeetingUser> userList) {
        this.userList = userList;
    }

    public MeetingInterval getInterval() {
        return interval;
    }

    public void setInterval(MeetingInterval interval) {
        this.interval = interval;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public void addParticipants(List<MeetingUser> userList) {}
}
