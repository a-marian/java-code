package abcde.classes;

/**
 * A class is initialized at most once by the JVM before it is references or used.
 * All static final variables must be assigned a value exactly once, either when they are declared or in a static initializer.
 * All final fields must be assigned a value exactly once, either when they are declared in an instance initializer or in constructor.
 * Non-final static and instance variables defined without a value are assigned a default value based on their type.
 * Order of ini
 * */

public class Okapi extends GiraffeFamily {
    static { System.out.print("F");} // second

    public Okapi(int stripes){
        super("sugar");
        System.out.print("G");
    }

    { System.out.print("H"); }

    public    int getNumberOfHumps(){
        return 4;
    }

    public static void main(String[] arguments) {
        new Okapi(1);
        System.out.println();
        new Okapi(2);
        Okapi o = new Okapi(3);
        System.out.println(o.getNumberOfHumps());
    }

}
