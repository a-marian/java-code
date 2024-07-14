package daily.code.abcde.decisions;

/**
 * Pattern matching with an if statement is implemented using the instanceof operator.
 * Flow scoping means a pattern variable is only accessible if the compiler can discern its type.*/

public class PatternMatching  {

    static void printIntegerGreaterThan5(Number number) {
        if(number instanceof final Integer data && data.compareTo(5) > 0)
            System.out.print(data);
    }

    static void printOnlyIntegers(Number number){
        if(number instanceof Integer data)
            System.out.print(data.intValue());
        else
            return;
    }

    private static void printType(Object o){
        if(o instanceof Integer bat ){
            System.out.print("int");
        } else if (o instanceof  Integer bat && bat < 10){
            System.out.print("small int");
            // } else if (o instanceof Long bat || bat <= 20) { not compile
            System.out.print("long");
        } else { //default not compile
            System.out.print("unknown");
        }
    }

    private static void getFish(Object fish){
        if(!(fish instanceof String guppy))
            System.out.print("Eat!");
        else if(!(fish instanceof String puppy)){
            throw new RuntimeException();
        }
        System.out.print("Swim!");
    }

    public static void main(String[] args) {
        printIntegerGreaterThan5(6);
        Integer val = 7;
        if(val != null){}
        System.out.println("\n print type");
        printType(11);
        getFish("goldie");
    }




}
