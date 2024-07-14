package abcde.classes;

public class GiraffeFamily {

    static { System.out.print("A");} // first

    {System.out.print("B");} //third

    public GiraffeFamily(String name){
        this(1);
        System.out.print("C"); // fifth
    }

    public GiraffeFamily(){
        System.out.println("D"); //sixth
    }
    public GiraffeFamily(int stripes){ //
        System.out.print("E"); //fourth
    }

    public int getNumberOfHumps(){
        return 1;
    }
}
