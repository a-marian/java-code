package abcde.mammal;

abstract class Animal {

    abstract CharSequence chew();

    public Animal(){
        System.out.println(chew());
    }
}
