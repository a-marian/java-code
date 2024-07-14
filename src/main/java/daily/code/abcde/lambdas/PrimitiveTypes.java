package abcde.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class PrimitiveTypes {

    public static void main(String[] args) {
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

        ToDoubleBiFunction<Integer, Integer> convertSumToDouble = (n1, n2) -> n1 + n2;
        Integer num1 = 23;
        Integer num2 = 34;
        System.out.println(convertSumToDouble.applyAsDouble(num2,num1));
        ToIntBiFunction<Integer, Integer>  converterbi = ( a1,  a2) -> a1+a2;
        int a = 120;
        int b = 230;
        System.out.println(converterbi.applyAsInt(a,b));

        ToIntFunction<Double> ob = n -> (int)(n*10);
        System.out.println(ob.applyAsInt(14.5));

        ToLongFunction<Long> convertToLong = (n1) -> n1 * 129L;
        long n2 = 34;
        System.out.println(convertToLong.applyAsLong(n2));

        ToDoubleFunction<Integer> convertToDouble = n1 -> n1 +3;
        System.out.println(convertToDouble.applyAsDouble(2));





    }
}
