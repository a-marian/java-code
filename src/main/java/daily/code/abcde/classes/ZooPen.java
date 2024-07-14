package abcde.classes;

public class ZooPen {

    private static final int NUMBERS = 45;
    //treats is a reference variable
    private static final String[] treats = new String[34];

    final static String name = "Ronda";
    static final int bamboo;
    //static final double height; //DOES NOT COMPILE
    static {bamboo = 5;}

    public static void main(String[] args) {
        //does not compile becais NUMBERS was declared as final
        //NUMBERS = 34;
        //You can modify the array's content. All the compiler can do is check that
        // we don't try to reassign treats to point to a different object.
        treats[0] = "Hello";
    }
}
