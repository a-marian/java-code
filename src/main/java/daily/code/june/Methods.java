package daily.code.june;

import abcde.classes.Animal;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Methods {
        static String var;


    public  static void main(String... args) {
        Integer bad= 5;
        short gorilla = 8;
        Short gorillaLong = gorilla;
        var="Hola estatico";
        System.out.println("var = " + var);
        String[] movies = {"Inside out", "Kunfu PAnda", "Mi villano favorito"};
        cinema(LocalDateTime.now(), movies , "luna", "sol", "flor", null);
        //effectivelyFinal();
        // checkZooAnimal();
    }
    private void feed(){
        int monkey=0;
        if(monkey >0){
            var giraffe= monkey++;
            String name;
            name = "geoffrey";
        }
        String name = "milly";
        var food=10;
        while(monkey <=10){
            food=0;
        }
        name=null;
    }

    public static void cinema(LocalDateTime dateTime, String[] movies, String... customers){

        System.out.println("dateTime = " + dateTime);
        Arrays.stream(movies).forEach(System.out::println);
        System.out.println("customers = " +Arrays.toString(customers));

    }
    public static String effectivelyFinal(String[]aa, int... vals){
         String name = "Harry the Hippo";
        var size=10;
        boolean wet;
        if(size > 100) size++;
        name.substring(0);
        wet = true;
        return name;
    }
    public static void checkZooAnimal(){
        final int rest=5;
        final abcde.classes.Animal animal = new Animal(12);
        System.out.println("animal = " + animal);
        final int[] friends = new int[4];
        friends[0] =6;
        friends[2] =3;
        Arrays.stream(friends).forEach(System.out::println);
    }

         static void otherStringExamples(){
             var sb= new StringBuilder("MARIANELAALEX");
             System.out.println(sb.reverse());
            ///prints alphabet
             for (char i = 'a'; i <= 'z' ; i++) {
                 System.out.print(i+" ");
             }
            //// replace()
             var textReplaced = """
                    a
                    b
                    c
                """;
             System.out.println(textReplaced.replace("b", "boat "));

            //// formatted()
             var phrase =String.format(" hello %s!%n"
                     +" I was wondering if you can lend me %d $us%n" +
                     "because I need to pay a loan about %f%n" +
                     "Your contribution will help me a lot." +
                     "Thank you very much%nSincerely,%nLuna", "Sol", 100, 2000.00f );
             System.out.println(phrase);

             var player="James";
             var score=102.40;
             var total=200;
             System.out.println("-----other formatted example---");
             System.out.println("%s:%n Score: %f out of %d".formatted(player, score, total));

             ///// translateEscapes()
             var str2="1\\t2";
             str2+= "a\bb c\tluna what is this?";
             System.out.println(str2);
             System.out.println(str2.translateEscapes());
             var concat="a "
                     +"  b\n"
                     +"  c\n";
             System.out.println(concat.length());
             System.out.println(concat.indent(1));
             System.out.println(concat.indent(1).length());
        ///////////////////
             var word = " holiday trip  ";
             var text=" abc\t hola\n";
             var text2=" dfg\t hello\n";
             var html = """
         <html>
            <body>
                <p>Hello, world</p>
            </body>
         </html>
         """;
             System.out.println(word.strip());
             System.out.println(word.stripLeading());// remove blank spaces from the beginning
             System.out.println(word.stripTrailing());//remove blank space from the ending
             // both prints the same
             System.out.println(html);
             System.out.println(html.stripIndent());
             System.out.println(text); //prints with blank space and break line
             System.out.println(text.trim()); // prints removing blank space and brek line
             System.out.println(text2.trim());
            /////////////
             var name="animals";
             //pos->   0123456
             System.out.println(name.indexOf(0)); // -1
             System.out.println(name.indexOf("al")); //4
             System.out.println(name.indexOf('a', 4)); //4
             System.out.println(name.indexOf("al", 3)); //4

             System.out.println(name.substring(3)); // mals
             System.out.println(name.substring(3,5)); // ma
             System.out.println(name.substring(3,3)); //empty
             System.out.println(name.substring(6,1)); // throws exception
         }
}
