package abcde.methods.one;

import abcde.methods.rope.*;
import static abcde.methods.rope.Rope.*;

public class Chimp {
    private static Rope rope1 = new Rope();
    private static Rope rope2 = new Rope();
    {
        System.out.println(rope1.LENGTH);
    }
    public static void main(String[] args) {
        Rope.swing();
        new Rope().swing(); // ugly but compile
        System.out.print(LENGTH);

        rope1.LENGTH = 2;
        rope2.LENGTH = 5;
        System.out.println(rope1.LENGTH);


    }
}
