package abcde.classes;

class Antelope{
    public Antelope(int p){
        System.out.print("4"); // fourth
    }
    {System.out.print("2");} // third
    static {System.out.print("1");} // first
}
public class Gazelle  extends Antelope {
    public Gazelle(int p){
        super(6);
        System.out.print("3"); // sixth
    }

    public static void main(String hopping[]) {
        new Gazelle(0);
        //printing -> 182493
    }

    static{ System.out.print("8");} // second
    {System.out.print("9");} // fifth
}
