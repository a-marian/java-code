package abcde.streams;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExerciseStreams {


    public static void main(String[] args) {

        List<String> names1 = List.of("tom", "george", "catherine","marian","elon","jhon");
        List<String> names2 = List.of("pablo", "july", "marian", "peter","george", "flor");

        //Filter names that exists in both lists
        List<String> duplicateNames = names1.stream().filter(names2::contains).toList();
        System.out.println("Found duplicate names in both lists");
        System.out.println(duplicateNames);

        //Joining both lists in only one, then sort in natural order
        List<String> allNames = Stream.of(names1, names2).flatMap(Collection::stream).sorted().toList();
        System.out.println("Found duplicate names in both lists");
        System.out.println(allNames);

        //Printing each philosopher name as array of chars
        Stream<String> philosophers = Stream.of("Seneca", "Epicteto", "Socrates", "Aristoteles");
        Function<String, IntStream> ints = CharSequence::chars;
        Function<IntStream, Stream<Character>> chars = s -> s.mapToObj(val -> (char)val);
        philosophers.map(ints.andThen(chars)).forEach(s -> System.out.println(s.collect(Collectors.toList())));


        System.out.println("\nflatmap() mix for lists");
        // flatMap() mix one, two, three lists in one stream
        var one = List.of();
        var two = List.of("alligator", "impala","cheetah");
        var three = List.of("elephant", "giraffe", "zebra", "lion");
        Stream<List<?>> safari = Stream.of(three, one, two);
        safari.flatMap(Collection::stream).sorted()
                .forEach(s -> System.out.print(s+" "));

        // other way to concat streams and sort in reverse order
        System.out.println("\nconcat() mix for streams");
        var four = Stream.of("alligator", "impala","cheetah");
        var five = Stream.of("elephant", "giraffe", "zebra", "lion");
        Stream.concat(five, four).sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.print(s+" "));

    }


    public  static void reduceAndPredicate(){
        BinaryOperator<Integer> op = (a,b) -> a*b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(1,2);
        Stream<Integer> porkies = Stream.of(3,7,9);

        empty.reduce(op).ifPresent(System.out::println); // --
        oneElement.reduce(op).ifPresent(System.out::println); // 2
        porkies.reduce(op).ifPresent(System.out::println); // 189

        Stream<String> letters = Stream.of("s", "t", "r", "e", "a","m", "s");
        String byPredicate = letters.reduce("", (s,c) -> s+c);
        System.out.println("By predicate: "+ byPredicate);
        Stream<String> abcde = Stream.of("a", "b", "c", "d", "e");
        String byMethod = abcde.reduce("", String::concat);
        System.out.println("By method ref: "+ byMethod);
    }
}
