package abcde.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Bull extends Mammal {

    public List<String> play(){
        return List.of("hello", "hola", "oa", "ola");
    }

    public void printBodyParts( List<?> list){
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        Bull bull = new Bull();
       // List<?> list = new ArrayList<String>(); compile but is not possible to add data
        //List<?> list = new ArrayList<?>(); // NOT COMPILE
       // List<? extends Object> list = new ArrayList<String>(); // compile but is not possible to add data because: capture of ? extends Object
        //   List<? super String> list = new ArrayList<>(); OK
        // ArrayList<String> list = new ArrayList<>(); OK
        List<String> list = new ArrayList<>(); // OK
        list.add("barrel");
        list.add("tail head");
        list.add("hump");
        list.add("ribs");
        list.add("sheath");
        bull.printBodyParts(list);
    }
}
