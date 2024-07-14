package abcde.decisions;

import java.util.ArrayList;
import java.util.List;

public class Loops {

    public static void multiTerms(int x){
        for (long y=0, z=4; x < 5 && y < 10; x++, y++){
            System.out.println(x + " "+ z);
        }
    }
    public static void myFavoriteNumbers(){
        List<Integer> myFavoriteNumbers = new ArrayList<>();
        myFavoriteNumbers.add(10);
        myFavoriteNumbers.add(14);

        for (var a: myFavoriteNumbers) {
            System.out.print(a + ", ");
            break;
        }
        for (int b: myFavoriteNumbers) {
            System.out.print(b + ", ");
            continue;
            //System.out.print(b + ", ");  //DOES NOT COMPILE
        }
        for (Object c: myFavoriteNumbers) {
            System.out.print(c +", ");
        }

    }
    private static void printNumbers(int[] weather){
        for (int i = 0; i <= weather.length-1 ; ++i) {
            System.out.print(weather[i]+" ");
        }
        System.out.println("\n way 2:");
        for (var v: weather) {
            System.out.print(v+" ");
        }
        System.out.println("\n way 3:");
        for (int i = weather.length-1; i >=0 ; i--) {
         System.out.print(weather[i]+" ");
        }
        System.out.println("\n way 4:");
        for (int i = 0,  j=3; i < weather.length ; ++i) {
            System.out.print(weather[i]+" ");
        }
        System.out.println("\n way 4:");
        for (int i = 0; i < 10 && i < weather.length; i++) {
            System.out.print(weather[i]+" ");
        }
    }
    private static void printInstrument(String instrument){
        final String CELLO= "cello";
        String viola = "viola";
        int p = -1;
        switch (instrument){
            case "bass": break;
            case CELLO: p++;
            default: p++;
            case "VIOLIN": p++;
            case "viola": ++p; break;
        }
        System.out.println(p);
    }
    public static void main(String[] args) {
        multiTerms(1);
        int[] weather = {1,2,3,4,5,6};
        printNumbers(weather);
        printInstrument("violin");

    }
}
