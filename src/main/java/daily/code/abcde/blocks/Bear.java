package abcde.blocks;

/*
 * Garbage collection allows the JVM to reclaim memory for other objects.
 * An object may be eligible for garbage collection but never removed from the heap.
 * An object is eligible for garbage collection once no reference to it are accessible in the program.
 *  */
public class Bear {
    private Bear pandaBear;
    private void roar(Bear b){
        System.out.println("Roar!");
        pandaBear = b;
    }

    public static void main(String[] args) {
        Bear brownBear = new Bear();
        Bear polarBear = new Bear();
        brownBear.roar(polarBear);
        polarBear = null;
        brownBear = null;

        System.gc();
    }


}
