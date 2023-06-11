package abcde.methods.one;

import java.util.ArrayList;

//import static java.util.Collections.*;
import static java.util.Collections.sort;

public class RopeSwing {

    private static final String leftRope;
    private static final String rightRope;
    private static final String bench;
    private static final String name = "name";
    static{
        leftRope = "name";
        rightRope = "right";
        bench = "bench";
    }

    public static void main(String[] args) {
       System.out.println(bench +" "+name);
    }

    public void method(ArrayList<String> list){
        sort(list);
    }
}
