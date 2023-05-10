package abcde.generics;


import java.util.List;

public class Antear extends Mammal {
    // protected void eat(List<Object> input){}
    // protected void eat(ArrayList<Integer> input){}

    public List<Integer> play(){
        return List.of(1,2,3,5,6);
    }
}