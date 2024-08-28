package daily.agost;

public interface Omnivore {

    static int amount =10;
    static boolean gather = true;
    static void eatGrass(){}
    //int findMore(){return 3}
    default float rest(){ return 2;}
    private int chew() { return 13; } // protected, public is a modifier not permited here

    private static void eatLEaves(){}
}
