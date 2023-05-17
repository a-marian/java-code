package abcde.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Arbitrary {

    public static Optional<Double> average(int... scores){
        if(scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score: scores) {
            sum += score;
        }
        return Optional.of( (double) sum/ scores.length);


    }

    public static void main(String[] args) {

        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1,2,3,4,5,6,7,8,9);
        empty.forEach(System.out::println);
        singleElement.forEach(System.out::println);
        System.out.println(" skipping three elements");
        fromArray.skip(3).forEach(System.out::println);

        var list = List.of("aaa", "abc", "ccc");
        Stream<String> fromList = list.parallelStream();
        fromList.forEach(System.out::println);

        Stream<Integer> oddNumberUnder100 = Stream.iterate(1, n -> n < 30, n -> n+2)
                .limit(10);

        oddNumberUnder100.forEach(n -> System.out.print(" ,num: "+ n));

        Stream<String> puppies = Stream.of("beto", "rambo", "chiqui", "napo");

        System.out.println(list.stream().findAny().get());
        System.out.println(puppies.findAny());
        System.out.println("\n generate random nums");
        Stream<Double>  randoms  = Stream.generate(Math::random).limit(20) ; // infinite
        randoms.forEach(s -> System.out.print(" r: "+ s));
        System.out.println("\n iterate nums");
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n+2); // infinite
        oddNumbers.limit(10).forEach(o -> System.out.print(", odd: "+ o));



        int[] array = {60, 78,49,80,96,74,65,88};
        System.out.println(average(array)); // Optional[73.75]
        System.out.println(average()); // Optional.empty
        Optional<Double> opt = average(90,100,80);
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(() -> Math.random()));
        System.out.println(opt.orElseThrow());
    }
}
