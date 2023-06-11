package abcde.strings;

/**
 * equals() standard method to check values inside the String rather than the string reference itself.
 * If a class doesn't have an equals() method,
 * Java determines whether the references point to the same object, which is exactly what == does.
 * If you can call toString() on two StringBuilder instances, it will check reference equality.
 * You can call toString() on StringBuilder to get a String to check for equality instead.
 *
 * since strings are everywhere in Java, they use up a lot of memory. In some production applications,
 * they can use a large amount of memory in the entire program. Java realizes that many strings repeat
 * in the program and solves this issue by reusing common ones.
 * The string pool, also known as the intern pool, is a location in the Java Virtual Machine(JVM) that collects
 * all these strings.
 * The string pool contains literal values and constants that appear in your program.
 *
 *  **/
public class Equality {

    private static void comparing(){
        var one = new StringBuilder();
        var two = new StringBuilder();
        var three = one.append("a");
        System.out.println(one == two);
        System.out.println(one == three);
        System.out.println(one.equals(three));

        var x = "Hello World";
        var y = "Hello World";
        // The JVM created only one literal in memory.
        // The x and y variables both point to the same location in memory -> "Hello World";
        // therefore , the statement outputs true.
        System.out.println(x == y);

        var z = " Hello World".trim();
        System.out.println(x == z);
        System.out.println("%s equals %s".formatted(x,z) +" " + x.equals(z));
        System.out.println("comparing string intern()");
        var first = "rat" + 1;
        var second = "r"+"a"+"t"+"1";
        var third = "r"+"a"+ "t"+ new String("1");
        System.out.println(first == second);
        System.out.println(first == second);
        System.out.println(first == second.intern());
        System.out.println(first == third);
        System.out.println(first == third.intern());
    }

    public static void main(String[] args) {
        comparing();
    }

}
