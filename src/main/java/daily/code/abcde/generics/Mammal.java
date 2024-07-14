package abcde.generics;

import java.util.ArrayList;
import java.util.List;

public class Mammal extends Animal {

    public <T> List<T> play(){
        return new ArrayList<>();
    }
    public CharSequence sleep(){
        System.out.println("Sleeping");
        return "hello";
    }

    // below methods override walk method from Animal
    public List<String> walk(List<String> list) {return null;}
    //public ArrayList<String> walk(List<String> list) {return null;}
}
