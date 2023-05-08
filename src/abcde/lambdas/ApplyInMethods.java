package abcde.lambdas;

import java.io.IOException;
import java.util.*;
import java.util.function.*;


public class ApplyInMethods {

    //Predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T item : list) {
            if (p.test(item)) {
                results.add(item);
            }
        }
        return results;
    }

    //Consumer
    public static <T> void forEachList(List<T> list, Consumer<T> c) {
        for (T item : list) {
            c.accept(item);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T item:list) {
            result.add(f.apply(item));
        }
        return result;
    }

    public static double[] applyFunctionToAllValues(double[] values, DoubleUnaryOperator function) {
        double[] result = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = function.applyAsDouble(values[i]);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {

        //Predicate functional interface
        List<String> listOfStudents = List.of("Antonio", "Rodrigo", "Rodolfo", "Juan Francisco",
                "Maria Sol", "Estefania", "Silvana", "Daniela", "Candelaria");
        Predicate<String> nonEmptyStringPredicate = (String s) -> s != null && !s.isEmpty();
        List<String> nonEmpty = filter(listOfStudents, nonEmptyStringPredicate);
        forEachList(nonEmpty, System.out::println);

        //Consumer functional interface
        List<String> museList = List.of("Hysteria", "Psycho", "Uprising", "Knights of Cydonia");
        forEachList(museList, System.out::println);
        forEachList(museList, (String s) -> System.out.println(s.length()));

        //Function functional interface
        List<String> list = map(List.of("may", "jun", "july"), String::toUpperCase);
        forEachList(list, System.out::println);

        //DoubleUnaryOperator
        double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
        DoubleUnaryOperator square = (double x) -> x * x;
        double[] squares = applyFunctionToAllValues(values, square);
        System.out.println(Arrays.toString(squares));

        // ObjDoubleConsumer example to print discount fo data in prices map.
        Map<String, Double> prices = new HashMap<>();
        prices.put("apple", 0.99);
        prices.put("banana", 0.49);
        prices.put("orange", 0.79);
        // Define the behavior to parameterize using an ObjDoubleConsumer
        ObjDoubleConsumer<String> discount = (String product, double percentage) -> {
            double price = prices.get(product);
            double discountedPrice = price * (1 - (percentage / 100));
            prices.put(product, discountedPrice);
        };
        // Apply the behavior to a specific product and discount percentage
        discount.accept("apple", 10);
        // Print the new discounted price for the product
        System.out.println("New price for apple: $" + prices.get("apple"));



    }
}
