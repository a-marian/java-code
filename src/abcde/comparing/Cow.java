package abcde.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cow implements Comparable<Cow> {

    private String name;
    private int birthYear;
    private Cow(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public int compareTo(Cow o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", weight=" + birthYear +
                '}';
    }

    public static void main(String[] args) {
        //implementing Comparator
        Comparator<Cow> compareByBirthYear = Comparator.comparingInt(Cow::getBirthYear)
                .thenComparing(Cow::getName);

        var cows = new ArrayList<Cow>();
        cows.add(new Cow("lola", 1995));
        cows.add(new Cow("berta", 1999));
        cows.add(new Cow("tina", 2000));
        cows.add(new Cow("marta", 2005));
        cows.add(new Cow("rosa", 2001));

        Collections.sort(cows);
        System.out.println(cows); // ordered by name
        // [Cow{name='berta', weight=1999}, Cow{name='lola', weight=1995}, Cow{name='marta', weight=2005}, Cow{name='rosa', weight=2001}, Cow{name='tina', weight=2000}]

        Collections.sort(cows, compareByBirthYear);
        System.out.println(cows); // ordered by birth year
        // [Cow{name='lola', weight=1995}, Cow{name='berta', weight=1999}, Cow{name='tina', weight=2000}, Cow{name='rosa', weight=2001}, Cow{name='marta', weight=2005}]

    }
}
