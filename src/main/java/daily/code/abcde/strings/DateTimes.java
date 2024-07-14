package abcde.strings;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

public class DateTimes {

    public static void main(String[] args) {
        //zoneDateTimes();
        var date = LocalDate.of(2022, Month.APRIL, 30);
        date = date.plusDays(2);// if you don't override the variable with
        date = date.plusYears(3); // the plus operation it will continue as it was declared at initial

        System.out.println(date.getYear() +" "+ date.getMonth() +" "+date.getDayOfMonth());
    }


    private static void zoneDateTimes(){
        var date = LocalDate.of(2022, Month.MARCH, 13);
        var time = LocalTime.of(1,30);
        var zone = ZoneId.of("US/Eastern");
        var dateTime1 = ZonedDateTime.of(date, time, zone);
        var dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
        long diff = ChronoUnit.HOURS.between(dateTime1, dateTime2);
        int hour = dateTime2.getHour();
        boolean offset = dateTime1.getOffset() == dateTime2.getOffset();
        System.out.println("diff ="+ diff); // diff =1
        System.out.println("hour ="+ hour); // hour =3
        System.out.println("offset ="+ offset); // offset =false
    }

    private static void dateTimes(){

        var date = LocalDate.of(2022, 4, 3);
        var time = LocalTime.of(1,10,10);
        var dateTime = LocalDateTime.of(date, time);
        dateTime = dateTime.plusDays(2);
        dateTime = dateTime.plusHours(5);
        System.out.println(dateTime.getYear()+" "+dateTime.getMonth()+" "+dateTime.getDayOfMonth()+" "+ dateTime.getHour());

        System.out.println(date);
        date = date.plusDays(5);
        System.out.println(date);
        date = date.plusWeeks(1);
        System.out.println(date);
        date.plusMonths(2).plusYears(3);
        System.out.println(date);

        var date2 = LocalDate.of(2024, Month.SEPTEMBER, 20);

        System.out.println(dateTime);
        System.out.println( dateTime.minusSeconds(1000));
        dateTime.minusMinutes(30);
        System.out.println(dateTime);
        System.out.println(dateTime.minusWeeks(3));
    }

    private static void workWithPeriods(){
        var date = LocalDate.of(2022, Month.JANUARY, 20);
        var date2 = LocalDate.of(2024, Month.SEPTEMBER, 20);
        var start = LocalDate.of(2022, Month.JANUARY, 1);
        var end = LocalDate.of(2022, Month.MARCH, 30);
        performPeriods(start, end, Period.ofMonths(1) );

        //there are five ways to create periods:
        var annually = Period.ofYears(1);
        var quartely = Period.ofMonths(3);
        var everyThreeWeeks = Period.ofWeeks(3);
        var everyOtherDay = Period.ofDays(4);
        var everyYearAndWeek = Period.of(1, 0, 7);

        System.out.println(date.plus(annually));
        System.out.println(date2.plus(Period.ofMonths(2)));
        System.out.println("Annually");
        performPeriods(start, end, annually);
        System.out.println("Quartely");
        performPeriods(start, end, quartely);
        System.out.println("Every three weeks");
        performPeriods(start, end, everyThreeWeeks);
        System.out.println("every other day");
        performPeriods(start, end, everyOtherDay);
        System.out.println("Every year and week");
        performPeriods(start, end, everyYearAndWeek);
    }

    private static void performPeriods(LocalDate start, LocalDate end, Period period){
        var upTo = start;
        while(upTo.isBefore(end)){
            //check if still before end
            System.out.println("give new toy "+  upTo);
            upTo = upTo.plus(period); // add a month
        }
    }

    private static void workingWithDurations(){
        System.out.println("First instant: "+ Instant.now());
        //Durations
        var daily = Duration.ofDays(1);
        var hourly = Duration.ofHours(1);
        var everyMinute = Duration.ofMinutes(1);
        var everyTenSeconds = Duration.ofSeconds(10);
        var everyMilli = Duration.ofMillis(10);
        var everyNano = Duration.ofNanos(100);
        var dailyC = Duration.of(1, ChronoUnit.DAYS);
        var hourlyC = Duration.of(1, ChronoUnit.HOURS);
        var everyMinuteC = Duration.of(1, ChronoUnit.MINUTES);
        var everyMilliC = Duration.of(1, ChronoUnit.SECONDS);
        var everyNanoC = Duration.of(1, ChronoUnit.MILLIS);
        System.out.println(daily +" "+ dailyC);
        System.out.println(everyMilli +" "+ everyMilliC);
        System.out.println(hourly +" "+ hourlyC);
        System.out.println(everyMinute +" "+ everyMinuteC);
        System.out.println(everyNano +" "+ everyNanoC);
        System.out.println(everyTenSeconds +" "+ dailyC);

        System.out.println("Last instant "+Instant.now());
    }
}
