package abcde.lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static abcde.lambdas.Person.Sex.FEMALE;
import static abcde.lambdas.Person.Sex.MALE;

public class SocialNetwork {

    public static void main(String[] args) {
        List<Person> persons = Person.getPersons();

        printPersonOlderThan(persons, 40);
        System.out.println("---CRITERIA---");
        printPersonsByCriteria(persons, 50,100, FEMALE);
        System.out.println("---PREDICATE---");
        printPersonsWithPredicate(persons,
                (Person p) -> p.getAge() > 50 && p.getAge() < 100 && p.gender() == FEMALE,
                Person::printPerson);
        System.out.println("---GENERICS---");
        processElements(persons, p -> p.gender() == MALE && p.getAge() < 50, Person::email, System.out::println);
        System.out.println("---aggregate operations---");
        persons.stream().filter(
                p -> p.gender() == MALE
                && p.getAge() > 50
                && p.getAge() < 100).map(Person::email)
                .forEach(System.out::println);
    }


    //Create methods that search for members that match one characteristic
    public static void printPersonOlderThan(List<Person> roaster, int age){
        for (Person p: roaster) {
            if(p.getAge() >  age){
                p.printPerson();
            }
        }
    }

    //method to match characteristic in range
    public static void printPersonsByCriteria(List<Person> roaster, int minAge,
                                              int maxAge, Person.Sex gender){
            for (Person p: roaster){
                if(p.getAge() > minAge && p.getAge() < maxAge && p.gender() == gender){
                    p.printPerson();
                }
            }
    }

    public static  void printPersonsWithPredicate(List<Person> personList,
                                                  Predicate<Person> checker, Consumer<Person> cons){
        for (Person p :personList) {
            if(checker.test(p))
                cons.accept(p);
        }
    }

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
                                              Function<X,Y> mapper, Consumer<Y> block){
        for (X p: source) {
            if(tester.test(p)){
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}
