package abcde.records;

import java.util.Comparator;
import java.util.TreeSet;

public record Sorted (int id, String text) implements Comparable<Sorted>, Comparator<Sorted> {

    @Override
    public int compareTo(Sorted o) {
        return text.compareTo(o.text);
    }

    @Override
    public int compare(Sorted o1, Sorted o2) {
        return o1.id - o2.id;
    }

    @Override
    public String toString() {
        return ""+ id;
    }

    public static void main(String[] args) {
        var s1 = new Sorted(44, "first");
        var s2 = new Sorted( 23, "second");
        var t1 = new TreeSet<Sorted>();
        t1.add(s1);
        t1.add(s2);
        var t2 = new TreeSet<Sorted>(s1);
        t2.add(s1);
        t2.add(s2);

        System.out.println(t1 +" "+ t2); // [44, 23] [23, 44]
    }
}
