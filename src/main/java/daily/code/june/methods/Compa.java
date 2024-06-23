package daily.code.june.methods;

import static daily.code.june.methods.Buddy.COFFEE;

public class Compa {

    public static void main(String[] args) {
        // It is not possible call to the drink method from Rope
        // because
         Buddy.drink();
         new Buddy().drink(); // ugly but allowed
        System.out.println(COFFEE);
    }
}
