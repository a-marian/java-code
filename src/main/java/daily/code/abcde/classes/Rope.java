package abcde.classes;

public class Rope {

    public static int LENGTH = 5;
    public static int len = 0;
    static{
        LENGTH = 10;
    }
    public static void swing(){
        System.out.print("swing");
    }
    public void climb(){
     System.out.print("climb");
    }
    public static void play(){
        swing();
//        climb();
    }
    public void feed(){
        int monkey = 0;
        if(monkey > 0){
            var giraffe = monkey++;
            String name;
            name = "geoffrey";
        }
        String name = "milly";
        var food = 10;
        while(monkey <= 10){
            food = 0;
        }
        name = null;
    }

    public static void main(String[] args) {
        Rope rope = new Rope();
        rope.play();
        Rope rope2 = null;
        System.out.print("-");
        rope2.play();
    }
}
