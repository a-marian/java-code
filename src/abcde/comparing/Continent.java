package abcde.comparing;

import java.util.TreeSet;

public class Continent implements Comparable<Continent> {

    private String name;
    public Continent(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Continent o) {
        return name.compareTo(o.name); // sorts ascendant by name
    }

    public static void main(String[] args) {
        var continents = new TreeSet<Continent>();
        continents.add(new Continent("Europe"));
        continents.add(new Continent("Antarctica"));
        continents.add(new Continent("Asia"));
        continents.add(new Continent("Africa"));
        continents.add(new Continent("Oceania"));
        continents.forEach(System.out::println);
    }
}
