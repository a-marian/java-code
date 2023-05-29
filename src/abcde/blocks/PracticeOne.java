package abcde.blocks;

public class PracticeOne {
    private static  char charValue;
    private static float floatValue;
    static double doubleValue;
    private char charValueInstance;
    private float floatValueInstance;
    private double doubleValueInstance;

    PracticeOne(){
        System.out.println(charValueInstance +" "+ floatValueInstance+" "+ doubleValueInstance);
        // It prints small null, 0.0, 0.0
    }

    public static void main(String... args) {

        short height = 1, weight = 3;
        short zebra = (short)( weight *  height);
        double ox = 1 + height * 2 + weight;
        int myFavoriteNumber = 8;
        //local variables don't have default values
        //references types in class variables default to null

        String _1980_s = ""; // an indentifier can't start with numbers
        String Public = "public"; // NOT good practice
        int possibleValue = 0_333_2; //  does not make sense but compiles
        String _QW_ = "volve internet";
        //String java.lang = ""; // NOT COMPILE

        System.out.println(" float value default : " + floatValue);
        System.out.println(" char value default : " + charValue);
        System.out.println(" double value default: " + doubleValue);

        PracticeOne one = new PracticeOne();

        short numPets = 5000; // to short you can only assign int values as much  longer.
        int  numGrains = (int)213345345345454.1; // to int you can only assign int values or cast other data types



    }
}
