package com.ab.core.localization;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Arpit Bhardwaj
 *
 * LocalDateTime,LocalDate,LocalTime are immutable objects
 */

public class DateTimeZoneDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2021, Month.DECEMBER,7,12,44,23,34);
        //LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("Default Formatted Date Time: " + localDateTime);
        System.out.println("Year: " + localDateTime.getYear());
        System.out.println("Month: " + localDateTime.getMonth());
        System.out.println("Day: " + localDateTime.getDayOfMonth());
        System.out.println("Hour: " + localDateTime.getHour());
        System.out.println("Minute: " + localDateTime.getMinute());
        System.out.println("Second: " + localDateTime.getSecond());
        System.out.println("Nano Second: " + localDateTime.getNano());

        //extract local date and local time from localdatetime
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        //combine local date and local time
        LocalDateTime localDateTime1 = localDate.atTime(localTime);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);

        //new date and time objects can be produced using methods withXXX(),plusXXX(),minusXXX()
        LocalDateTime localDateTime3 = localDateTime1.withMinute(14).withDayOfMonth(3).plusHours(3).minusHours(1);
        System.out.println("LocalDateTime: " + localDateTime3);

        LocalDate today = LocalDate.now();
        LocalDate foolsDay = LocalDate.of(2021,Month.APRIL,1);

        Period howLong = Period.between(foolsDay, today); //represent an amount of time
        System.out.println(howLong.getMonths());
        Duration twoHrs = Duration.ofHours(2);//represent an amount of time
        System.out.println(twoHrs.getNano());
        Instant now = Instant.now();
        System.out.println(now);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("Time Zone: " + timeZone.getDisplayName(Locale.getDefault()));

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Zoned Date time: " + zonedDateTime.toString());

        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println("Timestamp: " + timestamp.toString());

        //custom format pattern
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss.SSS");
        System.out.println("Custom Formatted Date Time: " + localDateTime.format(dateTimeFormatter));
        var df = DateTimeFormatter.ofPattern("MMMM' at 'h' o''clock'");
        System.out.println("Custom Formatted Date Time: " + localDateTime.format(df));

        //standard format patterns defined by FormatStyle enum
        DateTimeFormatter dateTimeFormatterFr = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("Formatted Date Time: " + localDateTime.format(dateTimeFormatterFr));
    }
}
