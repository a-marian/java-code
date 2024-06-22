package daily.code.june;

import java.util.ArrayList;
import java.util.List;

public class MakingDecisions {

    public static void main(String[] args) {
        int[] weather={1,2,3,4,5,6};
        //print(weather);
        //printType(56);

    }
    static void getFish(Object fish){
        // name variable should be defined once time and not used then for other declaration
        if(!(fish instanceof final String guppy))
            System.out.println("Eat!");
        else if (!(fish instanceof String guppy2)) {
            throw new RuntimeException();
        }
        System.out.println("Swim!");
    }
    
    static void printType(Object o){
        if(o instanceof Integer bat){
            System.out.print(" int ");
        } else if (o instanceof Integer bat && bat <10 ) {
            System.out.print(" small int ");
      //  } else if (o instanceof Long bat || bat <=20) { NOT COMPILE
            System.out.print(" long ");
     //   } default { NOT COMPILE
            System.out.print(" unknown ");
        }
    }

    private static void print(int[] weather){
        for(var w:weather){
            System.out.println(w);//weather[i]);
        }

        for(int i=0; i<= weather.length-1; ++i){
            System.out.println(weather[i]);
        }
    }
    static void printReptile(int category){
        // switch expression should cover all cases adding an optional default branch
        var type= switch (category){
            case 1,2 -> "Snake";
            case 3,4 -> "Lizard";
            case 5,6 -> "Turtle";
            case 7,8 -> "Alligator";
            default -> "None";
        };
        System.out.println(type);
    }

    private void otherExamples(){
        //--------------------------//
        /// if case have a condition, it needs to have both yield branch
        byte amphibian=1;
        String name= "Frog";
        String color = switch (amphibian){
            case 1 -> {yield "Red";}
            case 2 ->
            {
                if(name.equals("Frog"))
                    yield "Green";
                else
                    yield "Black";
            }
            case 3 -> {yield "Purple";}
            default -> throw new RuntimeException();
        };
        System.out.println(color);
        //------//

        // output?
        String  instrument= "violin";
        final String CELLO = "cello";
        String viola="viola";
        int p = -1;
        switch(instrument){ // break is important for switch statement
            case "bass":System.out.print(" a "); break;
            case CELLO: System.out.print(" b "); p++;
            default: System.out.print(" c "); p++; break;
            case "VIOLIN": System.out.print(" d "); p++;
            case "viola": System.out.print(" f "); ++p; break;
        }
        System.out.println(p);
        ///////////

        int penguin=50, turtle=75;
        boolean older = penguin >= turtle;
        if(older = true) System.out.println("Success"); //1
        else if (penguin != 50) System.out.println("Other!"); //3
        else System.out.println("Failure"); //2


        var tailFeathers=3;
        final var one= 1;
        switch(tailFeathers){
            case one: System.out.print(3 + " ");
            default: case 3: System.out.print(5+ " ");
        }
        while(tailFeathers > 1){
            System.out.print(--tailFeathers + " ");
        }

        int participants=4, animals=2, performers=-1;
        while((participants = participants+1) < 10){} // this will execute until participants = 10
        do{}while (animals++ <=1); //this will execute once time
        for(; performers<2; performers+=2){}

        System.out.println(participants);
        System.out.println(animals);
        System.out.println(performers);

        int temperature=4;
        long humidity= -temperature + temperature *3;
        if(temperature>=4)
            if(humidity < 6) System.out.println("Too low");
            else System.out.println("Just Right");
        else System.out.println("Too High");

        List<Integer> myFavoriteNumbers = new ArrayList<>();
        myFavoriteNumbers.add(10);
        myFavoriteNumbers.add(14);
        for (var a:myFavoriteNumbers) {
            System.out.print(a+ ", ");
            break;
        }

        for(int b: myFavoriteNumbers){
            // continue; this should work before below line
            System.out.println(b + ", ");
        }

        for(Object c: myFavoriteNumbers){
            System.out.println(c + ", ");
        }

        int count =0;
        BUNNY: for(int row=1; row <=3; row++)
            RABBIT:for (int col = 0; col < 3; col++) {
                if((col+row) %2 == 0)
                    continue RABBIT;
                count++;
            }
        System.out.println(count);

        boolean keepGoing=true;
        int result=15, meters=10;
        do{} while (keepGoing); // parenthesis is important

        final char a='A', e='E';
        char grade = 'B';
        switch (grade){
            default:
            case a:
            case 'B', 'C': System.out.println("great ");
            case 'D': System.out.println("good "); break;
            case e:
            case 'F': System.out.println("not good");
        }
    }



}
