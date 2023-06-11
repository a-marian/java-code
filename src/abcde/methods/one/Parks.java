package abcde.methods.one;

public class Parks extends  ParkTrip{
    @Override
    void parkCar() {
        super.parkCar();
        System.out.println("Package access from same package");
     }

}
