package com.example.database_backend.utils;

import org.springframework.stereotype.Service;

@Service
public class SecondToHour {
    public static String convertSecondsToTime(long seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}
