package abcde.generics;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected void eat(List<Object> input){}
   // protected void eat(List<Double> input){} this method can't be declared because it causes
   // eat(List<Object>)' clashes with 'eat(List<Double>)'; both methods have same erasure

    public List<String> walk(List<String> list){return  null;}

    public static <T> T identify( T t){
        return  t;
    }

}

