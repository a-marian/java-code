package abcde.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dog implements Comparable<Dog> {

    private int id;
    private Dog(int id) {
        this.id = id;
    }
    @Override
    public int compareTo(Dog o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id + '}';
    }
    public static void main(String[] args) {
        var d1 = new Dog(34);
        var d2 = new Dog(12);
        var d3 = new Dog(10);
        var d4 = new Dog(15);
        var d5 = new Dog(11);

        System.out.println(d1.compareTo(d2)); // 34 - 12 = 22, what means that d1 is larger than d2
        System.out.println(d2.compareTo(d3)); // 12 - 10 =  2, what means d2 is larger than d3
        System.out.println(d3.compareTo(d4)); // 10 - 15 = -5, what means d3 is shorter than d4
        System.out.println(d4.compareTo(d5)); // 15 - 11 =  4, what means d4 is larger than d5

        List<Dog> dogs = new ArrayList<>(List.of(d1, d2, d3, d4, d5));
        Collections.sort(dogs);
        System.out.println(dogs);
    }
}
