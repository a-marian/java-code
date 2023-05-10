package abcde.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    }
}
