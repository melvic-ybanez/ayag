package com.melvic.ayag;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
    public static void schedule() {
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Notification.display();
                displayCurrentTime();
                timer.cancel();
            }
        };
        long delay = 1000L * 60 * 2;

        displayCurrentTime();
        timer.schedule(task, delay);
    }

    private static void displayCurrentTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(dateTime.toLocalTime().format(formatter));
    }
}
