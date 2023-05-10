package abcde.collects;

import java.util.*;
import java.util.function.BiFunction;

public class Maps {
    public static void main(String[] args) {

        Set<String> passwords = new TreeSet<>();
        passwords.add("123456");
        passwords.add("123ABC");
        passwords.add("password");
        passwords.add("Password$1");
        passwords.add("abcdef12");
        passwords.add("ZOCALO11");
        passwords.add("11111AB");
        // passwords.add(null); cause NullPointerException in runtime
        passwords.forEach(s -> System.out.print(s + ", "));
        // 11111AB, 123456, 123ABC, Password$1, ZOCALO11, abcdef12, password,

        System.out.println();


        Map<String, String> mapo = new HashMap<>();
        mapo.put("Tom", "bus");
        mapo.put("Jenny", "monopatin");
        mapo.put("Ana", "bicycle");
        mapo.put("Javier", null);
        mapo.putIfAbsent("Mary", "subway"); // if Mary key does not exit, it will be added to map
        //merge
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1:v2;
        mapo.merge("Sam","feet", mapper); // adding new row
        mapo.merge("Javier", "metro", mapper); // value for Javier key will be metro instead of null
        System.out.println(mapo); // {Tom=bus, Javier=metro, Ana=bicycle, Jenny=monopatin, Sam=feet, Mary=subway}

        mapOrTreemap();
    }

    public static void mapOrTreemap(){
        Map<String, String> map = new HashMap<>();
        map.put("koala","bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        map.putIfAbsent("leopard","meat");
        System.out.println("Australian animal:" + map.get("koala"));
        for(String key : map.keySet())
            System.out.print(key + ",");

        System.out.println("\n----------TREEMAP---------");
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("koala","bamboo");
        treeMap.put("lion", "meat");
        treeMap.put("giraffe", "leaf");
        treeMap.putIfAbsent("bear", "honey");
        System.out.println("African animal:" + map.get("giraffe"));
        for(String key : treeMap.keySet())
            System.out.print(key + ","); // print in alphabetic order

        System.out.println(map.containsKey("lion"));
        System.out.println(map.containsValue(""));
        System.out.println(treeMap.containsKey("koala"));
        System.out.println(map.containsValue("leaf"));
        System.out.println(map.size());
        System.out.println(treeMap.isEmpty());
        //iterating
        treeMap.forEach((k,v) -> System.out.println(k +" eats "+ v));
        map.values().forEach(v -> System.out.println("food: "+v));
        map.keySet().forEach(k -> System.out.println("Animal: "+ k));

        System.out.println("Zoo: " + map.getOrDefault("dog", "animal")); // if dog is not in map animal will be printed
    }
}
