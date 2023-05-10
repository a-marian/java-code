package abcde.comparing;

import java.util.*;

public class Rabbits {
     record Rabbit(int id){}

    public static void main(String[] args) {

         List<Rabbit> rabbits = new ArrayList<>();
            rabbits.add( new Rabbit(5));
            rabbits.add(new Rabbit(2));
            rabbits.add(new Rabbit(4));

        Comparator<Rabbit> comparator = (r1, r2) -> r2.id - r1.id;

        Collections.sort(rabbits, comparator); // descending order
        System.out.println(rabbits);
        Collections.reverse(rabbits); // ascending order
        System.out.println(rabbits);

        List<Integer> numbers = List.of(1,2,3,4,5,6,7);
        System.out.println(Collections.binarySearch(numbers,  4));

        var strings = new ArrayList<>(List.of("Java", "Python", "React", "Angular"));
        Collections.sort(strings);
        System.out.println(Collections.binarySearch(strings,  "Java"));
        System.out.println(strings);

        Comparator<Integer> lambda = (o1, o2) -> o2 -o1;
        Comparator<Integer> naturalOrder = Comparator.naturalOrder();
        Comparator<Integer> reverseOrder = Comparator.reverseOrder();

       // var list = List.of(24, 28, 22, 29, 20); // immutable list compiles but throws UnsupportedOperationException
        var list = Arrays.asList(24, 28, 22, 29, 20);
        Collections.sort(list, naturalOrder);
        Collections.reverse(list);
        System.out.println(list); // [29, 28, 24, 22, 20]
        Collections.reverse(list);
        System.out.println(list); // [20, 22, 24, 28, 29]
        System.out.println(Collections.binarySearch(list, 22)); // 1
    }
}
