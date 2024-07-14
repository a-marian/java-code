package abcde.methods.rope;

public class Rope {

    public static int LENGTH = 5;
    static String value2 = "yellow";
    String value3 = "yellow";
    static {
        LENGTH = 8;
        //value3="sss"; NOT COMPILE
    }
    {
        value2 = "orange";
        value3 = "blue";
    }
    public static void swing(){
        System.out.print("swing ");
    }
    private static void climb(){
        System.out.println("climb");
    }

    public static void play(){
        swing();
        climb();
    }

    public static void main(String[] args) {
        Rope rope = new Rope();
        rope.play();
        Rope rope1 = null;
        System.out.print("-");
        rope1.play();
    }
}
