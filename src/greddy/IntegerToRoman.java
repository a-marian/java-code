package greddy;

import java.util.TreeMap;

public class IntegerToRoman {

    private final  static TreeMap<Integer, String> map = new TreeMap<>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String intToRoman(int num) {

        if  (map.containsKey(num)) return map.get(num);
        int res = map.floorKey(num);

        return map.get(res)+ intToRoman(num-res);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(5));
        System.out.println(intToRoman(14));
        System.out.println(intToRoman(101));
        System.out.println(intToRoman(1987));
        System.out.println(intToRoman(1994));

    }
}
