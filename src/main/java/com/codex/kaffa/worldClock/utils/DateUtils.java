package com.codex.kaffa.worldClock.utils;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils  {
    public static String formatZonedDateTime(ZonedDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static ZonedDateTime convertToZone(OffsetDateTime time, ZoneId zoneId) {
        return time.atZoneSameInstant(zoneId);
    }
}
