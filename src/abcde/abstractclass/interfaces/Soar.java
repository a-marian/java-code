package abcde.abstractclass.interfaces;

public interface Soar {

    public static final int MAX_LENGTH = 3;
    public final static boolean UNDERWATER = true;
    public abstract void fly(int speed);
    abstract void takeoff();
    public abstract double dive();

    default double getTemperature(){
        return 10.0;
    }

     default String getName(){
        return "soar";
    }
}
