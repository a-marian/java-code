package abcde.abstractclass.interfaces;

public class Snake implements Soar {
    @Override
    public void fly(int speed) {

    }

    @Override
    public void takeoff() {

    }

    @Override
    public double dive() {
        return 0;
    }

    @Override
    public double getTemperature() {
        return Soar.super.getTemperature();
    }

    @Override
    public String getName() {
        return "snake";
    }
}
