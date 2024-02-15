package com.lld.stockbrokersystem;

import java.util.Date;

public abstract class Notification {
    private String notificationId;
    private Date creationDate;
    private String content;

    public abstract boolean sendNotification();
}

public class SmsNotification extends Notification {
    private int phoneNumber;

    public boolean sendNotification(){
        // definition
    }
}

public class EmailNotification extends Notification {
    private String email;

    public boolean sendNotification(){
        // definition
    }
}
