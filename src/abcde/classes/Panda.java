package abcde.classes;

public class Panda extends Bear {
    public Panda(String name) {
        super(name);
    }

    public static void eat(){
        System.out.println("Bear is chewing");
    }

    public static void main(String[] args) {
        eat();
    }
}
