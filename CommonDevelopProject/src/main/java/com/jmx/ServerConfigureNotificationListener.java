package com.jmx;

import javax.management.Notification;
import javax.management.NotificationListener;

public class ServerConfigureNotificationListener implements
        NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("SequenceNumber:" + notification.getSequenceNumber());
        System.out.println("Type:" + notification.getType());
        System.out.println("Message:" + notification.getMessage());
        System.out.println("Source:" + notification.getSource());
        System.out.println("TimeStamp:" + notification.getTimeStamp());
    }

    private void log(String message) {
        System.out.println(message);
    }

}
