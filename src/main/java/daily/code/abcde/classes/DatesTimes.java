package abcde.classes;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DatesTimes {

    public void creating(){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        var birthday = LocalDate.of(2023, Month.MAY, 14);
        var date1 = LocalDate.of(2023, 4, 14);
        var date2 = LocalDate.of(1998,  Month.APRIL, 30);
        System.out.println(birthday +" ; "+ date1 + " ; "+ date2);

        var time1 = LocalTime.of(6,14);
        var time2 = LocalTime.of(14, 23, 44);
        var time3 = LocalDateTime.of(birthday, time2);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);

        var zone = ZoneId.of("US/Eastern");
        var zoned1 = ZonedDateTime.of(birthday, time1, zone);
        System.out.println(zoned1);
    }

    public void manipulating(){
        var date = LocalDate.of(2024, Month.MAY, 12);
        var time = LocalTime.of( 4, 40);
        var dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);
        dateTime = dateTime.plusDays(2);
        dateTime = dateTime.plusYears(1).plusMonths(2);
        dateTime = dateTime.plusHours(1).plusMinutes(20).plusSeconds(10);
        System.out.println(dateTime);

        dateTime = dateTime.minusDays(0).minusMonths(2).minusYears(2).minusSeconds(5);
        System.out.println(dateTime);

        System.out.println("--------------------");
        System.out.println(Period.ofMonths(5)); // P5M
    }
    private static void performAnimalEnrichment(LocalDate start, LocalDate end){
        var upTo = start;
        while(upTo.isBefore(end)){
            System.out.println("give new toy: "+ upTo);
            upTo = upTo.plusMonths(1);
        }
    }

    private static void performAnimalEnrichPeriod(LocalDate start, LocalDate end,
                                                  Period period){
        var upTo = start;
        while(upTo.isBefore(end)){
            System.out.println("give new toy: "+ upTo);
            upTo = upTo.plus(period);
        }
    }
    public void performAnimals(){
        var start = LocalDate.of(2023, Month.MAY, 1);
        var end = LocalDate.of(2023, Month.SEPTEMBER, 30);
        performAnimalEnrichment(start, end);
        System.out.println("--------------------");
        performAnimalEnrichPeriod(start, end, Period.ofMonths(1));
        var annually = Period.ofYears(1);
        var quarterly = Period.ofMonths(3);
        var everyThreeWeeks = Period.ofWeeks(3);
        var everyTwoDay = Period.ofDays(2);
        System.out.println("--------ANNUALLY-----------");
        var start1 = LocalDate.of(2023, Month.JANUARY, 1);
        var end1 = LocalDate.of(2025, Month.DECEMBER, 31);
        performAnimalEnrichPeriod(start1, end1, annually);
        System.out.println("---------QUARTERLY-----------");
        end1 = end1.minusYears(2);
        performAnimalEnrichPeriod(start1, end1, quarterly);
        System.out.println("--------EVERY 3 WEEKS------------");
        end1 = end1.minusMonths(6);
        performAnimalEnrichPeriod(start1, end1, everyThreeWeeks);
        System.out.println("---------EVERY 2 DAYS-----------");
        end1 = end1.minusMonths(5);
        performAnimalEnrichPeriod(start1, end1, everyTwoDay);
        System.out.println("--------------------");
        System.out.println(Period.ofMonths(5)); // P5M
    }
    public void durations(){
        var daily = Duration.ofDays(1);
        var dailyC = Duration.of(1, ChronoUnit.DAYS);
        var hourly = Duration.ofHours(1);
        var hourlyC = Duration.of(1, ChronoUnit.HOURS);
        var everyNano = Duration.ofNanos(2);
        var everyNanoC = Duration.of(2, ChronoUnit.NANOS);
        System.out.println(hourlyC +" - "+ hourly);
        var start = LocalTime.of(5, 00);
        var end = LocalTime.of(5, 10);
        System.out.println(ChronoUnit.MINUTES.between(start, end));
        System.out.println(ChronoUnit.SECONDS.between(start, end));
        System.out.println(ChronoUnit.MILLIS.between(start, end));
        System.out.println(ChronoUnit.NANOS.between(start, end));

        LocalTime time = LocalTime.of(3,12,45);
        System.out.println(time);
        LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
        System.out.println(truncated);

    }

    public void example1(){
        LocalDate date = LocalDate.of(2023, 1, 20);
        LocalTime time = LocalTime.of(20,22,20);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zoned = ZonedDateTime.of(date, time,zone);

    }

    public void instants(){
        var now = Instant.now();
        System.out.println("Hello world");
        var later = Instant.now();
        var duration = Duration.between(now, later);
        System.out.println(duration.toMillis());

        var date  = LocalDate.of(2022, 5, 23);
        var time = LocalTime.of(11, 55,00);
        var zone = ZoneId.of("US/Eastern");
        var zoned = ZonedDateTime.of(date, time, zone);
        var instant = zoned.toInstant();
        System.out.println(zoned);
        System.out.println(instant);
    }

    public static void main(String[] args) {
        DatesTimes dt = new DatesTimes();
        //dt.creating();
        //dt.manipulating();
        //dt.durations();
        dt.instants();
    }
}
