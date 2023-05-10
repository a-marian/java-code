package abcde.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class sort players regarding name and score
 */

record Player (String name, int score) implements Comparable<Player> {

    //Sorting in descending order by score and if score is equal between two objects, sorting by name in ascending order.
    @Override
    public int compareTo(Player o) {
        if (score == o.score){
            return (name.compareTo(o.name));
        }
        return -Integer.compare(score, o.score);
    }
}

public class SortingComparator {

    public static void main(String[] args) {


        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));
        numbers.sort((a, b) -> b.compareTo(a)); // sorts in descending order
        System.out.println(numbers);

        Player[] player = new Player[5];

        player[0] = new Player("amy", 100);
        player[1] = new Player("david", 100);
        player[2] = new Player("heraldo", 50);
        player[3] = new Player("aakansha", 75);
        player[4] = new Player("zusana", 150);

        Arrays.sort(player);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name(), player[i].score());
            /** Result
                aleksa 150
                amy 100
                david 100
                aakansha 75
                heraldo 50
             *
             */
        }
    }
}
