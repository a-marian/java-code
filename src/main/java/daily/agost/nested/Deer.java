package daily.agost.nested;

public class Deer {

    enum Fruits { APPLES, BERRIES, GRASS}
    protected  static   class Diet {
        private Fruits getFavorite(){
            return Fruits.BERRIES;
        }
    }
    // To use any variable or method in main method, they have to be declared static also.
    public static void main(String[] args) {
        System.out.println(switch (new Diet().getFavorite()){
            case APPLES -> "a";
            case BERRIES -> "b";
            default -> "c";
        });
    }
}
