package com.lld.meetingscheduler;

import java.util.Date;

public class Notification {
    private int id;
    private String content;
    private Date creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void sendInvite(MeetingUser meetingUser){

    }

    public void cancelNotification(MeetingUser meetingUser){

    }
}
