package abcde.comparing;

import java.util.*;

record Horse(String name, int birthYear){ }

public class HorseComparator {

    public static void main(String[] args) {

        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("bronco", 2020));
        horses.add(new Horse("spirit", 2020));
        horses.add(new Horse("dakota", 2010));
        horses.add(new Horse("bayo", 2010));
        horses.add(new Horse("toby", 2005));
        horses.add(new Horse("rocinante", 2008));

        //implementing Comparator to sort firstly by birth year in descending order
        //then by name in ascending order
        Comparator<Horse> comparator = Comparator
                .comparingInt(Horse::birthYear).reversed()
                .thenComparing(Horse::name);

        Collections.sort(horses, comparator);

        horses.forEach(System.out::println);

    }
}
