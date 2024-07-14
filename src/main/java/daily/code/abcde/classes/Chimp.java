package abcde.classes;


 //import static getwork.Rope.LENGTH;

public class Chimp {
    private static Rope rope = new Rope();
    private static Rope rope1 = new Rope();
    {
       System.out.println( rope.len);
    }
    public static void main(String[] args) {
        rope.len = 2;
        rope1.len = 3;
        System.out.println(rope.len);
        //Rope.swing();
        //new Rope().swing();
        //System.out.println(LENGTH);
    }
}
