package abcde.collects;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollection {

    public static void main(String[] args) {


        Set<Character> letters = Set.of('a', 'b', 'c', 'd', 'f');
        Set<Character> copy = Set.copyOf(letters); //
        copy.forEach(System.out::println); // this prints the same content as letters set

        System.out.println("----TREE SET-----");
        Set<Character> tree = new TreeSet<>(letters); // adding letters set to treeet
        tree.forEach(System.out::println); // this prints ordered letters
        Set<Integer> nums = new TreeSet<>();
        nums.add(12);
        nums.add(10);
        nums.add(23);
        nums.add(16);
        nums.add(13);
        // nums.add(null); throws NullPointerException
        nums.forEach(System.out::println);
        System.out.println("after remove element");
        nums.removeIf(n -> n == 13);
        nums.forEach(System.out::println);

        checkingSet();
    }

    public static void checkingSet(){
        System.out.println("------ SET -------");
        Collection<? super CharSequence> set = new HashSet<>();
        set.add("Watermelon");
        set.add("Strawberry");
        set.add("Onion");
        set.add("Onion");
        set.add("Blueberry");
        set.add("Grapes");
        System.out.println(set);
        set.removeIf(s -> s.equals("Onion"));
        set.add(new StringBuilder("Banana"));
        System.out.println(set);
    }
}
