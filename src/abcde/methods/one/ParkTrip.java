package abcde.methods.one;

/**
 * private: The private modifier means the method can be called only from within the same class.
 * package access with package access, the method can be called only from a class in the same package.
 *   This one is tricky because there is no keyword. You simply omit the access modifier.
 *   Package access is sometimes referred to as  package-private or default access.
 * protected: The protected modifier means the method can be called only a class in the same package or a subclass.
 * public: The public modifier means the method can be called from anywhere.
 * */
public class ParkTrip {
    void parkCar(){
        System.out.println("Parking car");
    }

    protected void printPark(){
        System.out.println("Printing Park");
    }

    protected static final void biking(){
        System.out.println("Biking around the park");
    }
}
