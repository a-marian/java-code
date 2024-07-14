package abcde.collects;

import java.util.*;

public class Common {

    public static void main(String[] args) {
        String[] array = new String[]{"arnoldo", "beatriz", "carolina"};
        List<String> asList = Arrays.asList(array);
        List<String> copy = List.copyOf(asList);
        List<String> of = List.of(array);

        List<String> list = new ArrayList<>();
        list.add("airplane");
        list.add("bus");
        list.add("boat");
        list.add("train");
        System.out.println( list.indexOf("boat")); // 2
        System.out.println(list); //  [airplane, bus, boat, train]
        list.clear(); // delete all elements in list
        System.out.println(list); //  []


        var numbers = Arrays.asList(1,2,3,4,5);
        numbers.replaceAll(n -> n*2);
        numbers.forEach(n -> System.out.print(n +", "));

        List<String> linkedlist = new LinkedList<>();
        linkedlist.add("Twitter");
        linkedlist.add("Facebook");
        linkedlist.add("Instagram");
        linkedlist.add("Gmail");
        linkedlist.removeIf( s -> s.startsWith("G") ); // remove Gmail
        System.out.println(linkedlist.contains("subway")); //  print false
        System.out.println(linkedlist); // print [Twitter, Facebook, Instagram]


    }

    public  static void removeIfSomething(){
        List<String> list = new ArrayList<>();
        list.add("airplane");
        list.add("bus");
        list.add("boat");
        list.add("train");
        list.indexOf("boat"); //
        System.out.println(list);
        list.removeIf(s -> s.startsWith("T"));
        System.out.println(list);
    }
    public static void determinyEquality(){
        //determining equality
        var list1 = List.of(1,2);
        var list2 = List.of(3,4);
        var set1 = Set.of(1,2);
        var set2 = Set.of(3,4);
        System.out.println(list1.equals(list2));
        System.out.println(set1.equals(set2));
        System.out.println(list1.equals(set1));
        System.out.println(list2.equals(set2));
    }
}
