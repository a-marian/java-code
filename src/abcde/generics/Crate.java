package abcde.generics;

import abcde.classes.Horse;

interface Shippable<T>{
    void ship(T t);
}

class ShippableAbstractCrate<U> implements Shippable<U>{
    @Override
    public void ship(U u) {
        System.out.println(" abstract implementing an generic interface");
    }
}

class ShippableRobotCrate extends ShippableAbstractCrate<Animal> {
    @Override
    public void ship(Animal animal) {
        super.ship(animal);
    }
}
public class Crate<T> {
    private T contents;
    public T lookInCrate(){
        return  contents;
    }

    public void packCrate(T contents){
        this.contents = contents;
    }

    public static void main(String[] args) {
        Horse horse = new Horse();
        Crate<Horse> crateForHorse = new Crate<>();
        crateForHorse.packCrate(horse);
        Horse inCrate = crateForHorse.lookInCrate();
    }
}
