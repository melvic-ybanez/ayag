package com.melvic.ayag;

import java.io.IOException;

public class Notification {
    /**
     * Displays Mac or Linux specific notification
     */
    public static void display() {
        String title = "Ayag";  // TODO: Make this title configurable
        String message = "Time is up!";
        Runtime runtime = Runtime.getRuntime();
        String os = System.getProperty("os.name");
        String[] code = {};

        if (os.contains("Mac")) {
            code = new String[]{
                    "osascript", "-e", "display notification \"" + message + "\" with title \"" + title + "\""
            };
        } else if (os.contains("Linux")) {
            code = new String[]{
                    "zenity", "--notification", "--title=" + title, "--text=" + message
            };
        }

        try {
            runtime.exec(code);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage() + " See the stacktrace below for more details.");
            e.printStackTrace();
        }
    }
}
