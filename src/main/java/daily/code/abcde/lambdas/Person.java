package abcde.lambdas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static abcde.lambdas.Person.Sex.FEMALE;
import static abcde.lambdas.Person.Sex.MALE;

public record Person(String name, LocalDate birthday, Sex gender, String email, BigDecimal salary) {

    public Person(String name, LocalDate birthday, Sex gender, String email, BigDecimal salary) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
    }

    public enum Sex {
        MALE, FEMALE
    }

    public int getAge(){
        return LocalDate.now().getYear() - birthday().getYear();
    }

    public void printPerson(){
        System.out.println("Person[ name: "+ name() +", age: "+ getAge()+", " +
                "gender: "+ gender()+", email: "+ email() +"]");

    }

    @Override
    public String toString() {
        return "Person[ name: "+ name() +", age: "+ getAge()+", " +
                "gender: "+ gender()+", email: "+ email() +", salary: "+ salary() +"]";
    }

    public static List<Person> getPersons(){
        List<Person> persons = List.of(
                new Person("Ana", LocalDate.of(1990, Month.JANUARY, 1),
                        FEMALE, "teo@mail.com", BigDecimal.valueOf(9999) ),
                new Person("Louis", LocalDate.of(1950, Month.SEPTEMBER, 1),
                        MALE, "teo@mail.com", BigDecimal.valueOf(6590) ),
                new Person("Amy", LocalDate.of(1980, Month.MAY, 12),
                        FEMALE, "amy@mail.com", BigDecimal.valueOf(5000) ),
                new Person("Tommy", LocalDate.of(1978, 12, 12),
                        MALE, "tommy@mail.com", BigDecimal.valueOf(3500) ),
                new Person("Greta", LocalDate.of(1970, 2, 28),
                        FEMALE, "greta@mail.com", BigDecimal.valueOf(6000) )
        );
        return  persons;
    }
}
