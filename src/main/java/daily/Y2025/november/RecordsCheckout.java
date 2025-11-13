package daily.Y2025.november;

public class RecordsCheckout {

    record Painter (String name, String famousPaint, String bornPlace){

    }

    record Person(String firstName, String lastName, int age){
        // cannonical constructor(implicitly provided or explicitly declared)

        // non-canonicla constrctor taking only first and last name
        //assuming a default age
        Person(String firstName, String lastName){
            this(firstName, lastName, 0);
        }

        // another non-canonical constructor taking full name and age
        // Fixed overloaded constructor
        Person(String fullName, int age) {
            this(fullName.substring(0, 4), fullName, age);
        }


            //delegates to the canonical constructor
        }

}
