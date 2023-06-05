package abcde.classes;

public class CuttleFish {

    private String name = "swimmy";
    {System.out.println(name);} // third to print
    private static int COUNT=0;

    static { System.out.println(COUNT);} // first to print

    { COUNT++; System.out.println(COUNT); } // fourth to print

    public CuttleFish(){
        System.out.println("Constructor");
    } // fifth to print
    public static void main(String[] args){
        System.out.println("Ready"); // second to print
        new CuttleFish();
        /**
         *  0
            Ready
            swimmy
            1
            Constructor */
    }
}

