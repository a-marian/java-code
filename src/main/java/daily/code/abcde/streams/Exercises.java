package abcde.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Exercises {

    public static void main(String[] args) {

        // Filter even numbers from a list of integers.
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        Predicate<Integer> checkEvenNumbers =   num -> num % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(checkEvenNumbers).toList();
        //Printing even numbers
        System.out.println("even numbers");
        evenNumbers.forEach(n -> System.out.print(" "+n));

        //Find the maximum value from a list of integers.
        System.out.println("\n Maximum value from nums list");
        System.out.println("max value: "+numbers.stream().mapToInt(Integer::intValue).max().getAsInt());

        //Convert a list of strings to uppercase.
        List<String> strings = Arrays.asList("java", "react", "angular", "python", "php");
        System.out.println("\nstrings printed after uppercase change");
        strings.stream().map(String::toUpperCase).forEach(s -> System.out.print(s+" "));

        //Find the sum of all elements in a list of integers.
        IntStream nums = IntStream.of(23,45,56,43,12,86,54);
        System.out.println("\nTotal sum of nums list");
        System.out.println("total sum: "+nums.sum());

        //Remove duplicate elements from a list.
        System.out.println("\nRemove duplicate elements from a integers list.");
        var duplicate = Arrays.asList(1,2,3,1,2,4,3,6,7,9, 10, 11,9);
        IntStream integers = duplicate.stream().flatMapToInt(IntStream::of).distinct();
        integers.forEach(i -> System.out.print(" "+ i));

        //Count the number of strings that start with letter w.
        List<String> fruits = List.of("orange", "watermelon", "strawberry", "grapes", "kiwi", "banana", "peach");
        System.out.println("\nFruits after filtered watermelon");
        fruits.stream().filter(s -> !s.startsWith("w")).forEach(s -> System.out.print(" "+ s));

        // Sort a list of strings in alphabetical order.
        System.out.println("\nFruits list sorted in alphabetical order");
        fruits.stream().sorted().forEach(s -> System.out.print(" "+ s));

        //Find the average of all elements in a list of doubles.
        DoubleStream doubles = DoubleStream.of(12.34, 23.10, 24.67, 30.78, 34.44);
        System.out.println("\n average of doubles list");
        System.out.println("average: " +  doubles.average().getAsDouble());

    }
}
