package abcde.lambdas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Supplier;

import static abcde.lambdas.Person.Sex.FEMALE;


public class ConstructorReferences {

    public static void main(String[] args) {

        Supplier<Person> s1 = () -> new Person("Ana", LocalDate.of(1990, Month.JANUARY, 1),
                FEMALE, "teo@mail.com", BigDecimal.valueOf(9999) );



    }

}
