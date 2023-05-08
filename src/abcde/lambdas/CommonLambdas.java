package abcde.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class CommonLambdas {

    public static void main(String[] args) {
        //BiFunction
        BiFunction<Integer, Integer, Integer> function = Integer::sum;
        Integer result = function.apply(10, 20);
        System.out.println(result);

        //BinaryOperator
        BinaryOperator<Integer> funcion2 = (x1, x2) -> x1 + x2;
        Integer result2 = funcion2.apply(10, 20);
        System.out.println(result2);

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        Integer result3 = math(numbers, 0, (a,b) -> a+b);
        Integer result4 = math(numbers, 0, Integer::sum);
        System.out.println(result3 +" "+ result4);

        //IntBinaryOperator
        int[] primitives = {1,2,3,4,5,6,7,8,9,10};
        int lambda = mathPrimitive(primitives, 0, (a,b) -> a+b);
        int methodRef = mathPrimitive(primitives, 0, Integer::sum);
        System.out.println(lambda +" "+ methodRef);

        List<Person> persons = Person.getPersons();
        //create comparator
        Comparator<Person> comparing = Comparator.comparing(Person::salary);
        BinaryOperator<Person> bo = BinaryOperator.maxBy(comparing);
        // Person with highest pay
        Person highPayed = find(persons, BinaryOperator.maxBy(Comparator.comparing(Person::salary)));
        System.out.println("Person with high salary: "+ highPayed);
        //Person with lowest pay
        Person lowPayed = find(persons, BinaryOperator.minBy(Comparator.comparing(Person::salary)));
        System.out.println("Person with low salary: "+ lowPayed);

        //Same lambda, differnt functional interface
        Comparator<Person> c1 = (Person p1, Person p2) -> p1.salary().compareTo(p2.salary());
        System.out.println(c1.compare(highPayed, lowPayed));
        ToIntBiFunction<Person, Person> c2 = (Person p1, Person p2) -> p1.salary().compareTo(p2.salary());
        System.out.println(c2.applyAsInt(highPayed, lowPayed));
        BiFunction<Person, Person, Integer> c3 = (Person p1, Person p2) -> p1.salary().compareTo(p2.salary());
        System.out.println(c3.apply(highPayed, lowPayed));

        //method references
        Function<String, Integer> stringToInteger = Integer::parseInt; //(String s) -> Integer.parseInt(s);
        BiPredicate<List<String>, String> contains = List::contains; // (list, element) -> list.contains(element);



    }

    public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator){
        T result = init;
        for(T t: list){
            result = accumulator.apply(result, t);
        }
        return result;
    }

    public static int mathPrimitive(int[] array, int init, IntBinaryOperator accumulator){
        int result = init;
        for(int t : array){
            result = accumulator.applyAsInt(result, t);
        }
        return result;
    }

    public static Person find(List<Person> list, BinaryOperator<Person> accumulator){
        Person person = null;
        for (Person p : list) {
            if(person == null){
                person = p;
            }else {
                person = accumulator.apply(person, p);
            }

        }
        return person;
    }

}
