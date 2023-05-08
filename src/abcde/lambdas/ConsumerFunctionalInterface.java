package abcde.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;


public class ConsumerFunctionalInterface {

    interface BufferReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data.txt"))) {
            return p.process(br);
        }
    }
    public static BinaryOperator<Integer> multiplyTwoNumbers = (Integer x, Integer y) -> {
        System.out.println("  "+ x);
        System.out.println(" *"+ y);
        System.out.println("--------");
        System.out.println("  "+ x * y);
        return x * y;
    };



    public static void main(String[] args) {

       // String oneLine = processFile((BufferedReader br) -> br.readLine());
       // String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        Consumer<String> printer = System.out::println;
        printer.accept("Spring Security’s Servlet support is based on Servlet Filters");

        var name = "Marianela";
        Consumer<String> checkLength = name::contains;
        checkLength.accept("Marianela");

        Consumer<String> combined = checkLength.andThen(printer);
        combined.accept("Rainbow");

    }
}
