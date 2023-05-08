package abcde.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ConsumerExamples {

    public static void main(String[] args) {

        //In JDK source code Map.foreach accepts a BiConsumer
        Map<String, Double>prices = new HashMap<>();
        prices.put("apple", 234.20);
        prices.put("papaya", 345.90);
        prices.put("peach", 150.00);
        prices.put("orange", 300.00);
        prices.put("raspberries", 210.00);

        prices.forEach((k, v) -> System.out.println(k+ ":"+v));

        calculate(10, 20, (x, y) -> System.out.println("Addition: "+ x + y));
        calculate(10, 20, (x, y) -> System.out.println("Subtraction: " + x * y));
        calculate(40, 20, (x, y) -> System.out.println("Division: " + x / y));
        calculate(40, 20, (x, y) -> System.out.println("Modules: " + x % y));

      //  BiConsumer<String, String> consumer1 = (s1, s2) -> s1.equals();
    }

    static <T> void calculate(T num1, T num2, BiConsumer<T,T> consumer){
        consumer.accept(num1, num2);
    }

}
