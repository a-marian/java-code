package abcde.classes;

public class Horse {

    private String name = "Bronco";
    public static int count;
    public static void addGorilla(){
        count++;
    }
    public void babyGorilla(){ count--;}

    public void announcesBabies(){
        addGorilla();
        babyGorilla();
    }

    private void overloading(String a){

    }

    public int total;
    //DOES not compile because static variable is trying to use an instance variable
   // public static double average= total/count;
    public static  double average = count;

    static void hike(int month){
         switch(month){
           default: System.out.print("Unknown");
           case 1,2,3: System.out.print("Winter");
           case 4,5,6: System.out.print("Spring");
           case 7,8,9: System.out.print("Summer");
           case 10, 11,12: System.out.print("Fall");
       };
        System.out.println();
    }
    public static void first(int month){
        switch (month){
            default -> System.out.println("Unknown");
            case 1,2,3 -> System.out.println("Winter");
            case 4,5,6 -> System.out.println("Spring");
            case 7,8,9 -> System.out.println("Summer");
            case 10,11,12 -> System.out.println("Fall");
        }
    }

    public static void second(int fish){
        int length = 12;
        var name = switch (fish){
            case 1 -> "Goldfish";
            case 2 -> {yield "Trout";}
            case 3 -> {
                if(length > 10) yield "Blobfish";
                else yield "Green";
            }
            case 4 -> {yield "aa";}
            default -> "Swordfish";
        };
        System.out.println(name);
    }

    enum Season {WINTER, SPRING, SUMMER, FALL}
    public String third(Season season){
        return switch (season) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Summer";
            default -> "Happiness";
            };
        }
    public static void main(String[] args) {
       // hike(5);
       // first(0);
        second(3);
        // doees not compile because third();
    }
}
