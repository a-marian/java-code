package abcde.records;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public record Journalist(String name, int length) implements Comparable<Journalist>   {

    @Override
    public int compareTo(Journalist o) {
        return  this.length - o.length;
    }

    @Override
    public String toString() {
        return ""+ length;
    }

    public static void main(String[] args) {
        Journalist p1 = new Journalist("Ariel", 3);
        Journalist p2 = new Journalist("Nelson", 5);
        Journalist p3 = new Journalist("Cristina", 7);
        Journalist p4 = new Journalist("Ignacio", 1);

        List<Journalist> list = List.of(p1,p2, p3, p4);
        Comparator<Journalist> comparator = Comparator.comparing(Journalist::length).reversed();
        // list.sort(comparator); // THROWS EXCEPTION because Immutable object is modified
        //Collections.sort(list, Comparator.comparing(Journalist::length).reversed()); // THROWS EXCEPTION
        // because: Immutable object is passed where mutable is expected

        // Collections.sort(list); // THROWS EXCEPTION because Immutable object is passed where mutable is expected
        System.out.println(list);

        TreeSet set = new TreeSet<>(list); // treeSet stores in natural order by default because record has implemented Comparable
         // if not -> class abcde.records.Journalist cannot be cast to class java.lang.Comparable

        System.out.println(set);
    }


}
