package daily.code.june;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**NOTES
 * Calling equals() on two different arrays containing the same primitive values always returning false
 * */
public class CoreAPI {

    public static void main(String[] args) {
        String txt1 = """
                purr
                """;
        String txt2 = "";
        txt1.toUpperCase();
        txt1.trim();
        txt1.substring(1,3);
        txt1 +="two";
        System.out.println("txt1 = " + txt1);

        var base = "ewe\nsheep\\t";
        int len = base.length();
        System.out.println("len = " + len);
        int indent = base.indent(2).length();
        System.out.println("base after indent = " + base);
        System.out.println("indent = " + indent);
        int translate = base.translateEscapes().length();
        System.out.println("translate = " + translate);
        //// sorting arrays
        var arr = new String[]{"PIG", "pig", "123"};
        Arrays.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("Arrays.binarySearch(arr, \"Pippa\") = " + Arrays.binarySearch(arr, "Pippa"));
        var s = "Hello";
        var t = new String(s);
        if("Hello".equals(s)) System.out.println("one"); //true
        if(t == s) System.out.println("two"); // false
        if(t.intern() == s) System.out.println("three"); // true
        if("Hello" == s) System.out.println("four"); //true
        if("Hello".intern() == t) System.out.println("five"); //false

        var builder = new StringBuilder("12345");
        System.out.println("builder= "+builder.replace(2,4,"6").charAt(3));
        String str = "12345";
        System.out.println("str= "+str.replace("123", "1").charAt(2));

      
        double zero = Math.pow(2,2);
        double one = Math.min(5,3);
        double two = Math.random(); // random() provides double value
        double three = Math.floor(34.56);
        double four = Math.round(45.49);
        double five= Math.round(1.1); // provides long also float
        var doubles = new double[]{zero, one, two, three, four, five};
        Arrays.stream(doubles).forEach(System.out::println);

        var sb = new StringBuilder();

        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println("sb = " + sb);
        var zone = ZoneId.of("US/Eastern");
        var date= LocalDate.of(2022,11,7);
        var time= LocalTime.of(2, 15);
        var zoneDateCreated = ZonedDateTime.of(date, time, zone);
        System.out.println("zoneDateCreated = " + zoneDateCreated);
        int numFish =4;
        String var = String.valueOf(numFish +2);
        Date[] dates = new Date[2];

        //howWorksDatesTimes();
        //howWorksMathAPI();
        //getStringConstructorVsLiteral();
        //getBehaviour();
       // getConcatWork();
        //getSubStringWorks();
       // getMemory();
    }
    private static void howWorksDatesTimes(){
        var time1= LocalTime.of(6,15); // hour and minutes
        var time2= LocalTime.of(6,15,30); // hour minutes, seconds
        var time3 = LocalTime.of(6,15,30, 200);// hour, minutes, seconds, milliseconds
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);

        var dateTime1= LocalDateTime.of(2024, Month.JUNE, 22,11,10); // hour and minutes
        var dateTime2= LocalDateTime.of(1902, Month.FEBRUARY, 28, 14,30); // hour minutes, seconds
        Date utilDate = new Date();
        LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        var dateTime3= LocalDateTime.of(localDate, time1);// hour, minutes, seconds, milliseconds
        System.out.println("dateTime1= "+dateTime1);
        System.out.println("dateTime2= "+dateTime2);
        System.out.println("util.Date()= "+utilDate);
        System.out.println("time.LocalDate= "+localDate);
        System.out.println("time.DateTime= "+dateTime3);

        ZoneOffset.SHORT_IDS.values().forEach(System.out::println); // print all zone ID values
        var zone= ZoneId.systemDefault(); // get zoneID from system
        var zone1 = ZonedDateTime.of(2022, Month.APRIL.getValue(),
                20, 6,5,30,200, zone);
        System.out.println("zone1 = " + zone1);

        var zone2 = ZoneId.of("America/Los_Angeles");
        var zoneTime2 = ZonedDateTime.of(2022, Month.APRIL.getValue(),
                20, 6,5,30,200, zone2);
        System.out.println("zoneTime2 = " + zoneTime2);

        /// manipulating Dates and times
        var date =LocalDate.of(2020, Month.JANUARY, 20);
        System.out.println("date with no modifications: "+date);
        System.out.println("date plus 2 days: "+ date.plusDays(2));
        System.out.println("date plus 3 months: "+ date.plusMonths(3));
        System.out.println("date plus 1 year: "+ date.plusYears(1));
        System.out.println("date plus 5 weeks: "+ date.plusWeeks(5));

        /// manipulating Dates and times
        System.out.println("date minus 10 days: "+ date.minusDays(10));
        System.out.println("date minus 3 weeks: "+ date.minusWeeks(3));
        System.out.println("date minus  1 year and 2 months: "+ date.minusYears(1).minusMonths(2));
        // zoneDateTime updated
        System.out.println("zoneDateTime= "+zone1.minusDays(10).plusYears(2).minusNanos(100));

        // Periods
        var annually= Period.ofYears(1);
        System.out.println("annually = " + annually);
        var quartely= Period.ofMonths(3);
        System.out.println("quartely = " + quartely);
        var everyThreeWeeks = Period.ofWeeks(3);
        System.out.println("everyThreeWeeks = " + everyThreeWeeks);
        //Duration
        System.out.println("daily= "+ Duration.ofDays(2));
        System.out.println("hourly= "+ Duration.ofHours(2));
        System.out.println("everyMinute= "+ Duration.ofMinutes(2));
        System.out.println("seconds= "+ Duration.ofSeconds(2));
        System.out.println("nanos= "+ Duration.ofNanos(2));

        var everyMilliseconds= Duration.of(1, ChronoUnit.MILLIS);
        System.out.println("everyMilliseconds = " + everyMilliseconds);
        var everyMicros= Duration.of(1, ChronoUnit.MICROS);
        System.out.println("everyMicros = " + everyMicros);

        // Working with ChronoUnit to get the duration between two dates or times
        LocalDate date1 = LocalDate.of(1810, Month.JULY, 10);
        System.out.println("date1 = " + date1);
        LocalDate date2 = LocalDate.of(2024, Month.JULY, 10);
        System.out.println("date2 = " + date2);
        System.out.println("years between date1 and date2 = " + ChronoUnit.YEARS.between(date1, date2));
        System.out.println("Centuries between date1 and date2 = " + ChronoUnit.CENTURIES.between(date1, date2));

        LocalTime timeOne = LocalTime.of(5,20);
        LocalTime timeTwo = LocalTime.of(11, 10);
        System.out.println("Hours bw time1 and time2: " + ChronoUnit.HOURS.between(timeOne, timeTwo));
        System.out.println("Minutes bw time1 and time2: " + ChronoUnit.MINUTES.between(timeOne, timeTwo));
        System.out.println("Seconds bw time1 and time2: " + ChronoUnit.SECONDS.between(timeOne, timeTwo));
        System.out.println("Nanos bw time1 and time2: " + ChronoUnit.NANOS.between(timeOne, timeTwo));

        // working with instants
        // You cannot convert a LocalDateTime to an Instant. Remember that an Instant is a point in time.
        // A LocalDateTime does not contain a time zone.
        // ZonedDateTime is convertible to Instant
        var instant = Instant.now();
        System.out.println("instant = " + instant);
        var newDate = new Date();
        System.out.println("newDate = " + newDate);
        var dateNow = LocalDate.now().plusMonths(9);
        var timeNOW = LocalTime.now().minusNanos(10);
        var zoneEST = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateNow, timeNOW, zoneEST);
        System.out.println("zonedDateTime = " + zonedDateTime);
        var instantFromZonedDateTime = zonedDateTime.toInstant();
        System.out.println("instantFromZonedDateTime = " + instantFromZonedDateTime);
    }

    private static void howWorksMathAPI(){
        System.out.println(Math.max(13,31)); //31
        long low = Math.round(123.45);
        System.out.println(low); //123
        /**The ceil() method takes a double value. If it is a whole number, it returns the same value
         * If it has any fractional value ¡, it rounds up to the next whole number. By contrast, the
         * floor() method discards any values after the decimal*/
        System.out.println(Math.round(123.3333f)); //123
        System.out.println(Math.ceil(45.44449));
        System.out.println(Math.floor(45.44449));
        //calculate exponents, potencia
        System.out.println(Math.pow(5, 2));
        //generate random
        System.out.println(Math.random());
    }

    private static void howWorksBinarySearch(){
        int[] numbers = {2,4,6,8};
        // binarySearch() returns the index position of target.
        //Target element not found in sorted array:
        /// Negative value showing one smaller than the negative of the index,
        /// where a match needs to be inserted to preserve sorted order
        // Target element found in sorted array: Index of match
        // Unsorted array: A surprise; this result is undefined.
        System.out.println(Arrays.binarySearch(numbers,2)); //  0
        System.out.println(Arrays.binarySearch(numbers,4)); //  1
        System.out.println(Arrays.binarySearch(numbers,1)); // -1
        System.out.println(Arrays.binarySearch(numbers,3)); // -2
        System.out.println(Arrays.binarySearch(numbers,9)); // -5


        int[]unsorted= {2,6,4,1};
        System.out.println(Arrays.binarySearch(unsorted,10)); // negative -5
    }

    private static void getStringConstructorVsLiteral(){
        long startTime, endTime;

        // Using string literals
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String str1 = "String" + i;
        }
        endTime = System.nanoTime();
        System.out.println("Time taken with literals: " + (endTime - startTime) + " ns");

        // Using new String()
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String str2 = new String("String" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken with new String(): " + (endTime - startTime) + " ns");

    }

    private static void getMemory(){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            String str = new String("String" + i).intern();
            list.add(str);
        }

        System.out.println("Finished creating strings");
    }

    private static void getSubStringWorks(){
        String original = "HelloWorld";
        String sub = original.substring(0, 5);

        String str1 = "Hello";
        System.out.println("sub == str1: " + (sub == str1));  // Should print: false

        String str2 = sub.intern();
        System.out.println("str1 == str2: " + (str1 == str2));  // Should print: true

    }

    private static void getConcatWork(){
        String str1 = "Hello" + "World";
        String str2 = "HelloWorld";

        System.out.println("str1 == str2: " + (str1 == str2));  // Should print: true

        String part1 = "Hello";
        String part2 = "World";
        String str3 = part1 + part2;

        System.out.println("str2 == str3: " + (str2 == str3));  // Should print: false

        String str4 = str3.intern();
        System.out.println("str2 == str4: " + (str2 == str4));  // Should print: true

    }

    private static void getBehaviour(){
        String str1="Hello";
        String str2= "Hello";
        System.out.println("str1==str2"+ (str1==str2));
        String str3= new String("Hello");
        System.out.println("str1==str3"+ (str1==str3));
        String str4 = str3.intern();
        System.out.println("str1==str4"+ (str1==str4));
    }

}
