package com.ab.core.localization;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeZoneDemo {
    public static void main(String[] args) {
        //LocalDateTime localDateTime = LocalDateTime.of(2021,3,7,12,44,23);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = localDateTime.toLocalTime();

        System.out.println("Year: " + localDateTime.getYear());
        System.out.println("Month: " + localDateTime.getMonth());
        System.out.println("Day: " + localDateTime.getDayOfMonth());
        System.out.println("Hour: " + localTime.getHour());
        System.out.println("Minute: " + localTime.getMinute());
        System.out.println("Second: " + localTime.getSecond());

        System.out.println("Default Formatted Date Time: " + localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss.SSS");
        System.out.println("Custom Formatted Date Time: " + localDateTime.format(dateTimeFormatter));

        Locale.setDefault(Locale.FRANCE);
        DateTimeFormatter dateTimeFormatterFr = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("France Formatted Date Time: " + localDateTime.format(dateTimeFormatterFr));

        Locale.setDefault(Locale.GERMANY);
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("Time Zone: " + timeZone.getDisplayName(Locale.getDefault()));

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Zoned Date time: " + zonedDateTime.toString());

        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println("Timestamp: " + timestamp.toString());
    }
}
