package abcde.lambdas;


import java.time.LocalDate;
import java.util.function.*;

public class BuiltInFunctionalInterface {

    /**
     * Method reference and lambda expression implementation for common functional interface
     */
    public static void main(String[] args) {

        //Supplier
        Supplier<LocalDate> methodRef = LocalDate::now;
        Supplier<LocalDate> lambda = () -> LocalDate.now();
        System.out.printf(" LocalDate by method reference %s \n", methodRef.get());
        System.out.printf("LocalDate by lambda %s \n", lambda.get());

        //Function
        Function<String, String> functionLambda = (String a) ->  a.toUpperCase();
        System.out.println(functionLambda.apply("lambda expression"));

        Function<String, String> stringStringFunction1 = String::toUpperCase;
        System.out.println(stringStringFunction1.apply("method reference"));

        //Consumer
        Consumer<String> printer = System.out::println;
        printer.accept("Stormtrooper");

        //BiPredicate
        BiPredicate<String, String> biFunction1 = String::equals;
        BiPredicate<String, String> biFunction2 = (String x, String y) -> x.equals(y);
        System.out.println("equals by method reference: "+ biFunction1.test("star", "stars"));
        System.out.println("equals by lambda: "+ biFunction2.test("wars", "wars"));

        //UnaryOperator
        var darth = "Darth ";
        UnaryOperator<String> unaryOperator = darth::concat;
        //BinaryOperator
        BinaryOperator<String> unaryOperator2 = ( a,  b) -> a.concat(b);
        System.out.println(unaryOperator.apply("Vader"));
        System.out.println(unaryOperator2.apply("Star", " Wars"));

        /** Some examples for Functional interface for primitive types */
        //IntBinaryOperator
        IntBinaryOperator res = (int a, int b) -> a * b;
        System.out.println("IntBinaryOperator applied: "+res);

        //IntPredicate
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println("Even number :"+ evenNumbers.test(14));
        //with lambda
        Predicate<Integer> oddNumber = (Integer i) -> i % 2 == 1;
        System.out.println("Odd number: "+ oddNumber.test(145));

    }

}
