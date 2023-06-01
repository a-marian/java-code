package abcde.classes;

public class Swan {
    int numberEggs;
    double annoyingButLegal = 1_00_0.0_0;
    double reallyUgly = 1______2;
    String eyeTest = "\"Java Study guide \"\n by Scott & Jeanne";

   boolean sunny = true, raining = false, sunday=true;


    String tree = """
            *
           * *
          * * *
            *
            """;

    public void varusing(){
        var d= "Hello";
        var a = 1/0;

    }




    public void printPattern(Number number){
        if (number instanceof Integer data && data.compareTo(5)> 0)
            System.out.println(data);
    }
    
    public void printPatternString(String text){
        if (text instanceof String s) {
            // Use the `s` variable as a String
            System.out.println(s);
        }
    }
    public void printSeason(int month){
        switch (month){
            case 1,2,3 -> System.out.println("Winter");
            case 4,5,6 -> System.out.println("Spring");
            case 7,8,9 -> System.out.println("Summer");
            case 10, 11, 12 ->  System.out.println("Fall");
        }
    }
    public static void main(String[] args) {
        Swan swan = new Swan();
        swan.numberEggs = 3;
        System.out.println(swan.numberEggs);
        System.out.println("annoying but legal= "+swan.annoyingButLegal);
        System.out.println("really ugly= " +swan.reallyUgly);
        System.out.println(swan.eyeTest);
        System.out.println(swan.tree);
        int a =2, b=4, c=2;
        System.out.println(a > b ? b < c ? b : 2 : 1);

        boolean goingToTheZoo = swan.sunny & swan.raining ^ swan.sunday;
        System.out.println(goingToTheZoo);
        long note = 1 * 2 + (byte)3;
        short melody = (byte) (double)(note *=2);

        swan.printPattern(5);

    }
}
