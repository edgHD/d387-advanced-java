package edu.wgu.d387_sample_code.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConversion {
    public static String convertTime(String zoneId) {

        ZonedDateTime presentationTimeUTC = ZonedDateTime.of(2024, 3, 20, 8, 30, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime localTime = presentationTimeUTC.withZoneSameInstant(ZoneId.of(zoneId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return localTime.format(formatter);
    }
}