package com.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.concurrent.atomic.AtomicLong;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean{
    private int seq = 0;
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        Notification notification = new Notification("jack.hi",++seq,System.currentTimeMillis(),"old name is "+this.name+", new name is "+name);
        super.sendNotification(notification);
        this.name=name;
    }

    @Override
    public void printHello() {
        System.out.println("Hello World! "+this.name);
    }

    @Override
    public void printHello(String name) {
        System.out.println("Hello "+ name);
    }
}
