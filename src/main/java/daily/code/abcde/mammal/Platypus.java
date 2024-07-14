package abcde.mammal;

public class Platypus extends Animal {
    @Override
    CharSequence chew() {
        return "yummy!";
    }

    public static void main(String[] args) {
        new Platypus();
    }
}
