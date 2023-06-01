package abcde.classes;

public class RopeSwing {
    private static final String leftRope;
    private static final String rightRope;
    private static final String bench = "bench";
    private static final String name = "name";
    private String www;
    {www="AA";}
    static {
        leftRope = "left";
        rightRope = "right";
    }
    static {
        // name was already initialized;
        //name = "name";
        // rightRope was
        //rightRope = "right";
    }

    public static void main(String[] args) {
        //NOT PERMITTED bench = "bench";
    }
}
