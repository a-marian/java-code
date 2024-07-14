package abcde.lambdas;

    @FunctionalInterface
    interface RandomGenerator{
    double getRandom();

    default void print(Number number){
     System.out.println(number);
    }
    }
    @FunctionalInterface
    interface StringChecker {
     String mixStrings(String str, String... strs);

     //Static method may be invoked on containing interface class only
     static void print(String str){
        System.out.println(str);
     }
     default void printer(String phrase){
         print(phrase);
     }
    }

public class StaticMethods {

    public static void main(String[] args) {

        RandomGenerator checker = Math::random;
        double x = checker.getRandom();
        checker.print(x);

        var strs = new String[]{"Memorize", "Imagination"};
        StringChecker stringChecker = String::join;
        stringChecker.printer(stringChecker.mixStrings("Reptilla", strs));

    }

}
