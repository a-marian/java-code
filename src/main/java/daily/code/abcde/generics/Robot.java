package abcde.generics;

import abcde.records.CrateRecord;

import java.util.*;

public class Robot {

    public static void main(String[] args) {

        List<?>  q = List.of("mouse", "cat");
        var p = List.of("mouse", "cat");
        // q.removeIf(String::isEmpty); NOT COMPILE
        //  q.removeIf(s -> s.length() = 4);  DO NOT COMPILE not found in object
        //  p.removeIf(String::isEmpty); NOT RUN UnsupportedOperationException
        // p.removeIf(s -> s.length() == 4); NOT RUN UnsupportedOperationException

        var greeting = new ArrayDeque<>();
        greeting.offerLast("hello");
        greeting.offerLast("hi");
        greeting.offerFirst("ola");
        greeting.pop();
        greeting.peek();

        while(greeting.peek() != null){
            System.out.print(greeting.pop()+"-"); // hello-hi-
        }

        HashSet<Number> number = new HashSet<Number>();
        HashSet<? super ClassCastException> set = new HashSet<Exception>();
        Map<String, ? extends Number> map = new HashMap<String, Integer>();
        Number n = 2;
        //map.put("key", 2); NO NOT COMPILE
        // map.put("key", Integer.valueOf(1)); DO NOT COMPILE capture of ? extends Number
        System.out.println(map);
        // List<Object> values = new ArrayList<? extends Object>(); NOT COMPILE
        // Wildcard type '? extends java.lang.Object' cannot be instantiated directly






    }

    public static void implementTricky(){
        TrickyCrate<Robot> robot = new TrickyCrate<>();
        robot.tricky("bot");

        Animal animal = new Animal();
        CrateRecord<Animal> animalRecord = new CrateRecord<Animal>(animal);
    }
}
