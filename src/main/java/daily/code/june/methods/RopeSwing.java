package daily.code.june.methods;

public class RopeSwing {
    private static final String leftRope;
    private static final String rightRope;
    private static final String bench;
    private static final String name= "name";

    static {
        leftRope="left";
        rightRope="right";
    }
    static {
       // name="name"; // DO NOT COMPILE
       // rightRope = "right"; // DO NOT COMPILE
        bench="Jazz";
    }

    public static void main(String[] args) {
       // bench="bench"; DO NOT COMPILE
    }
}
