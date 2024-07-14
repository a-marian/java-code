package abcde.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class PlayerComparator {

    record Player(String name, int score) {

        @Override
        public String toString() {
            return "Player: [ name: "+ name +", score: " + score + "] \n ";
        }
    }

    static class Checker implements Comparator<Player> {
        // overriding compare method to sort Players
        @Override
        public int compare(Player o1, Player o2) {
            if (o1.score() == o2.score()) {
                return (o1.name().compareTo(o2.name()));
            }
            return -Integer.compare(o1.score(), o2.score());
        }
    }

    public static void main(String[] args) {

        Player[] players = new Player[6];
        Checker checker = new Checker(); // Comparator implementation

        players[0] = new Player("Amy", 70);
        players[1] = new Player("Giovanni", 100);
        players[2] = new Player("David", 100);
        players[3] = new Player("Vishal", 140);
        players[4] = new Player("Andrey", 75);
        players[5] = new Player("Nikita", 150);

        Arrays.sort(players, checker);
        System.out.println( Arrays.toString(players));
    }
}