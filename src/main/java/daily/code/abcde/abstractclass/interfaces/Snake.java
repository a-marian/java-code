package daily.code.abcde.abstractclass.interfaces;

public class Snake implements abcde.abstractclass.interfaces.Soar {
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
        return abcde.abstractclass.interfaces.Soar.super.getTemperature();
    }

    @Override
    public String getName() {
        return "snake";
    }
}
