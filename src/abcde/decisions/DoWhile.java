package abcde.decisions;

public class DoWhile {

    public static void eatCheese(int bitesOfCheese, int roomBelly){
        while(bitesOfCheese > 0 && roomBelly > 0){
            bitesOfCheese--;
            roomBelly--;
        }
        System.out.println(bitesOfCheese+ " pieces of cheese left");
    }

    public static void getLizard(int lizard){
        do{
            lizard++;
        } while (false);
        System.out.println(lizard);
    }

    public static void findHungryHipo(int hungryHippopotamus){
        while(hungryHippopotamus > 0){
            do{
                hungryHippopotamus -= 2;
            }while (hungryHippopotamus>5);
            hungryHippopotamus--;
            System.out.print(hungryHippopotamus+", ");
        }
    }
    public static void printTemperature(int temperature){
        System.out.println("printing temperature");
        long humidity = -temperature + temperature *3;
        System.out.println("humidity result "+ humidity);
        if (temperature >= 4)
            if (humidity < 6) System.out.println("Too low");
            else System.out.println("Just right");
        else System.out.println("Too high");
    }
    private static void keepMeters(int meters, boolean keepGoing){
        int result=15;
        do{
            meters--;
            if(meters==8) keepGoing = false;
            result -= 2;
        } while(keepGoing);
        System.out.println(result);
    }

    private static void getSnake( double iguana){
        int snake = 1;
        do{
            System.out.print(snake++ +" ");
            iguana--;
        } while (snake <= 5); //
        System.out.println(iguana);
    }

    private static void createLabel(int w){
        int r=1;
        String name ="";
        while( w < 2){
            name += "A";
            do{
                r++;
                name += "B";
                if(name.length() > 0) name += "C";
                else break;
            } while (r <= 1);
             w++;
        }
        System.out.println(name);
    }

    private static void printIntegers(){
        int y = -2;
        do System.out.print(++y + " ");
        while (y <= 5);
    }
    public static void main(String[] args) {
        printTemperature(4);
        eatCheese(-3,-2);
        getLizard(0);
        findHungryHipo(8);
        System.out.println("d");
        createLabel(0);
        printIntegers();
    }





}
