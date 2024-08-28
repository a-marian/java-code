package daily.agost;

public class SwitchExercise {

    enum Season {
        WINTER, SPRING, SUMMER, FALL
    }
    public static void main(String[] args) {
            Season season = null;
            switch (season){
                case SPRING -> System.out.println("s");
                case FALL -> System.out.println("w");
                default -> System.out.println("missing data");
            }
    }
}
