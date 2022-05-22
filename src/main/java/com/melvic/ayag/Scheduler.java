package com.melvic.ayag;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
    public static void schedule() {
        Timer timer = new Timer("Timer");
        String startTime = getTimeString();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Notification.display();
                timer.cancel();

                reportResult(startTime, getTimeString());
            }
        };
        long delay = 1000L * 60 * 20;

        System.out.println("Timer is running...");
        timer.schedule(task, delay);
    }

    private static String getTimeString() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        return dateTime.toLocalTime().format(formatter);
    }

    private static void reportResult(String start, String end) {
        System.out.println("Timer has stopped.");
        System.out.println("Start time: " + start);
        System.out.println("End time: " + end);
    }
}
