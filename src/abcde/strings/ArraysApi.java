package abcde.strings;

import java.util.Arrays;

public class ArraysApi {

    public static void main(String[] args) {
        var arr = new String[]{"PIG", "pig","123"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [123, PIG, pig]
        System.out.println(Arrays.binarySearch(arr, "Pippa")); // -3

      //  java.util.Date[] dates[] = new java.util.Date[2][]; // weird declaration but compile
    }

}
