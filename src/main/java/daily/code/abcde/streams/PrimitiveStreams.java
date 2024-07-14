package abcde.streams;


import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1,2,3,4,5,6,7);
        System.out.println(intStream.filter(n -> n % 2 == 0));
        // generate a stream of
        IntStream intStream1 = IntStream.range(2,12);
        System.out.println(intStream1.findFirst().getAsInt());
        IntStream intStream2 = IntStream.rangeClosed(1,5);
        System.out.println(intStream2.average());

        LongStream longStream = LongStream.of(10,11, 12, 13, 14, 15, 16, 17);
        System.out.println("suma total: "+longStream.sum());

        LongStream longStream1 = LongStream.iterate(1, n -> n*2).limit(10);
        System.out.println("max value: "+longStream1.max());
        LongStream longStream2 = LongStream.iterate(0, n -> n +2).limit(12).skip(2);
        System.out.println("min value: "+longStream2.min());
        LongStream longStream3 = LongStream.of(9,8,7,6,5,4,3,2,1);
        System.out.println("average: "+longStream3.average());


        DoubleStream doubleStream = DoubleStream.of(12.23, 23.34, 34.45, 45.56, 56.67);
        System.out.println(doubleStream.average());

        DoubleStream doubleStream1 = DoubleStream.generate(Math::random).limit(10);
        doubleStream1.forEach(System.out::println);

        DoubleStream doubleStream2 = DoubleStream.of(12.5, 23.10, 10.45, 33.67);
        // static summary
        System.out.println(doubleStream2.summaryStatistics());

        List<Integer> primes = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());



    }
}
