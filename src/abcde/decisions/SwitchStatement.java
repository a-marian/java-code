package abcde.decisions;

import dypro.strings.MakingAnagrams;

import java.time.DayOfWeek;

public class SwitchStatement {

    public static void printAnimal(int animal){
        switch (animal){
            case 1,2: System.out.print("Lion");
            case 3: System.out.print("Tiger");
            default: System.out.print("Chubaka");
        }
        System.out.println("\nswitch after java 14");
        //prior to Java 14, the equivalent code would have been the following
        switch (animal){
            case 1: case 2: System.out.print("Lukas");
            case 3: System.out.print("Margie");
            default: System.out.print("Lisa");
        }
    }
    public static void printSeason(int month){
        switch (month){
            case 1,2,3: System.out.print("Winter");
            case 4,5,6: System.out.print("Spring");
            default: System.out.print("Unknown");
            case 7,8,9: System.out.print("Summer");
            case 10,11,12: System.out.print("Fall");
        }
    }
    // in previous examples you
    public static void printDayOfWeek(int day){
        switch (day){
            case 0:
                System.out.print("Sunday");
                break;
            case 1:
                System.out.print("Monday");
                break;
            case 2:
                System.out.print("Tuesday");
                break;
            case 3:
                System.out.print("Wednesday");
                break;
            case 4:
                System.out.print("Thursday");
                break;
            case 5:
                System.out.print("Friday");
                break;
            case 6:
                System.out.print("Saturday");
                break;
            default:
                System.out.print("Invalid value");
                break;
        }
    }

    /*** switch sxpressions ***/

    public static void printDayOfWeekExpression(int day){
        switch (day){
            case 0 -> System.out.print("Sunday");
            case 1 -> System.out.print("Monday");
            case 2 -> System.out.print("Tuesday");
            case 3 -> System.out.print("Wednesday");
            case 4 -> System.out.print("Thursday");
            case 5 -> System.out.print("Friday");
            case 6 -> System.out.print("Saturday");
            default -> System.out.print("Invalid value");
        }
    }

    private  static  void printSeasonExpression(int season){
        switch (season){
            case 1, 2, 3 -> System.out.print("Winter");
            case 4, 5, 6 -> System.out.print("Spring");
            case 7, 8,9 -> System.out.print("Summer");
            case 10, 11, 12 -> System.out.print("Fall");
        }
    }

    private static String getBear(int bear){
        return switch (bear){
            case 30 -> "Grizzly";
            default -> "Panda";
        };
    }

    private static String printFish(int fish, int length){
        var name = switch (fish){
            case 1 -> "Goldfish";
            case 2 -> {yield "Trout";}
            case 3 -> {
                if(length > 100) yield "Blobfish";
                else yield "Bobfish";
            }
            default -> "Swordfish";
        };
        return name;
    }
    enum Season {WINTER, SPRING, SUMMER, FALL}
    public static String getWeather(Season value){
        return switch (value){
            case WINTER -> "Cold";
            case SPRING -> "Warm";
            case SUMMER -> "Hot";
            case FALL -> "Windy";
        };
    }

    private static String printReptile(int category){
         return switch (category){
            case 1,2 -> "Snake";
            case 3,4 -> "Lizard";
            case 5,6 -> "Turtle";
            case 7,8 -> "Alligator";
             default -> throw new IllegalStateException("Unexpected value: " + category);
         };
    }
    private DayOfWeek getWeekDay(int day, final int thursday){
        int otherDay = day;
        int Sunday=0;
        switch (otherDay){
            default :
            //case 1: continue; does not compile continue is for loops
         //   case thursday: return DayOfWeek.THURSDAY;
            case 2,10: {
                System.out.println("Wuow!");
                break;
            }
           // case Sunday: return DayOfWeek.SUNDAY;
           // case DayOfWeek.MONDAY:  return DayOfWeek.MONDAY;
        }
        return DayOfWeek.FRIDAY;
    }
    enum Animal{BIRD, FISH, MAMMAL}
    private static void printLocation(Animal a){
        long type  = switch (a){
            case BIRD -> 1;
            case FISH -> 2;
            case MAMMAL -> 3;
            default -> 4;
        };
        System.out.println(type);
    }

    private static void printGrade(char grade){
        final var a = 'A';
          final char e = 'E';
        switch (grade){
            case a: System.out.print("excellent ");
            case 'B', 'C': System.out.print("great ");
            case 'D': System.out.print("good "); break;
            case e: System.out.print("regular ");
            default: case 'F': System.out.print("not good ");

        }
    }

    private static void findZookeeper(int id){
        System.out.print(switch (id){
            case 10 -> {yield "Jane";}
            case 20 -> {yield "Lisa";}
            case 30 -> "Kelly";
            case 40 -> "Sarah";
            default -> "Unassigned";
        });
    }

    private static void tailFeathers(){
        var tailFeathers = 3;
        final var one = 1;
        switch (tailFeathers){
            case one: System.out.print(3 + " ");
            default: case 3: System.out.print(5 + " ");
        }
        while(tailFeathers > 1){
            System.out.print(--tailFeathers+ " ");
        }
    }
    private static String printColor(byte amphibian, String name){
        return switch (amphibian){
            case 1 -> {yield "Red";}
            case 2 -> {
                if (name.equals("Frog")) yield  "Green";
                else yield "Black";
                }
            case 3 -> {yield "Purple";}
            default -> throw new RuntimeException();
        };
    }


    public static void main(String[] args) {
        printAnimal(3);
        System.out.println("\nFollowing printDayOfWeek is a good example how to implement switch statement");
        printDayOfWeek(1);
        System.out.println("\nFollowing printSEason will print everything because breaks are missing in code");
        printSeason(2);
        System.out.println("\n switch expressions");
        printDayOfWeekExpression(4);
        System.out.println("\n season by switch expression");
        printSeasonExpression(5);
        // using var as result value for switch
        System.out.println(getBear(30));
        System.out.println("\n Applying yield");
        System.out.println(printFish(3, 99));
        System.out.println(printFish(2, 99));
        System.out.println("if you use ENUMS, consider including a default branch in switch method ");
        System.out.println(getWeather(Season.WINTER));
        printLocation(Animal.MAMMAL);
        printGrade('B');
        tailFeathers();
        System.out.println("\n  de par en par");
        System.out.println(printColor((byte) 1, "Frog"));

    }
}

