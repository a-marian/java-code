package abcde.strings;

import java.util.stream.Stream;

public class MathApi {

    private static void ceilingFloor(){
        double e = Math.round(3.14);
        System.out.println("round of 3.14: "+ e);
        double c = Math.ceil(3.14); // 4.0
        System.out.println("ceil of 3.14: " + c);
        double f = Math.floor(3.14); // 3.00
        System.out.println("floor of 3.14:  "+f);
        double squared = Math.pow(5,2);
        System.out.println("5 squared up 2 " + squared);

        System.out.println(Math.max(3,5));
        System.out.println(Math.min(14,78));
    }

    public static void main(String[] args) {
       // ceilingFloor();

        int one = Math.min(5,3);
        long two = Math.round(5.5);
        double three = Math.floor(6.6);
        var doubles = new double[]{one, two, three};
        for (var d: doubles ) {
            System.out.print(d+", ");
        }
    }
}
