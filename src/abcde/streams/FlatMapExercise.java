package abcde.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapExercise {

    public static void main(String[] args) {

        //
        var integerList = Arrays.asList(12,23,34,45,67,78,90);
        IntStream numbers = integerList.stream().flatMapToInt(IntStream::of);
        numbers.forEach(n ->System.out.println(" "+n*2));

        //Printing each philosopher name as array of chars
        Stream<String> philosophers = Stream.of("Seneca", "Epicteto", "Socrates", "Aristoteles");
        Function<String, IntStream> ints = CharSequence::chars;
        Function<IntStream, Stream<Character>> chars = s -> s.mapToObj(val -> (char)val);
        philosophers.map(ints.andThen(chars)).forEach(s -> System.out.println(s.collect(Collectors.toList())));

        Stream<String> entrepeneurs = Stream.of("Musk", "Zuckerberg", "Gates", "Jobs", "Bezos");
        List<Character> listOfLetters = entrepeneurs.map(ints).flatMap(chars).toList();
        listOfLetters.forEach(x -> System.out.print(" "+x));

        System.out.println("\n--- Paired ---");
        List<?> list1 = Arrays.asList(1,2,3,4,5,6);
        List<?> list2 = Arrays.asList(7,8,9,10,11,12);

        Stream<List<?>> pairedNumbers = pairUp(list1, list2);
        pairedNumbers.forEach(System.out::println);

        List<Integer> nums1 = Arrays.asList(1,2,3);
        List<Integer> nums2 = Arrays.asList(3,4);

        List<int[]> pairs = nums1.stream().flatMap(i -> nums2.stream()
                .map(j -> new int[]{i,j}))
                .toList();
        pairs.forEach(n ->  Arrays.stream(n).forEach(s -> System.out.print(" "+ s)));

    }

    public static Stream<List<?>> pairUp(List<?> list1, List<?> list2){
        return list1.stream().flatMap(
                fromList1 -> {return list2.stream().map(
                        fromList2 -> { return Arrays.asList(fromList1,fromList2);
                        });
                });
    }
}
