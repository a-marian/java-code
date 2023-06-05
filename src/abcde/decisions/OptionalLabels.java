package abcde.decisions;

public class OptionalLabels {

    public static void findMatrix(int[][] list, int searchValue){
        int positionX=0, positionY = 0;
        PARENT_LOOP: for(int i=0; i<list.length; i++){
            for (int j = 0; j < list[i].length; j++) {
                if(list[i][j] == searchValue){
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if(positionX == -1 || positionY == -1){
            System.out.println("Value "+searchValue+" not found");
        } else {
            System.out.println("Value "+searchValue+" found at:"+
                    "("+positionX+","+positionY+")");
        }
    }

    public static void cleaningSchedule(){
        CLEANING: for(char stables = 'a'; stables <= 'd'; stables++){
        for(int leopard=1; leopard < 4; leopard++){
            if(stables == 'b' || leopard == 2){
                continue CLEANING;
            }
            System.out.println("Cleaning: "+stables+","+leopard);
            }
        }
    }

    private static void bunnyWithRabbit(){
        int count=0;
        BUNNY: for(int row = 1; row <= 3; row++)
            RABBIT: for(int col=0; col <3; col++) {
                if ((col + row) % 2 == 0)
                  break;
                count++;
            }
        System.out.println(count);
    }

    private static void checkLevels(int height){
        System.out.println("loco un poco nada mas");
        L1: while(height++ < 10){
            long humidity = 12;
            L2: do{
                if(humidity-- % 12 == 0) break L2;
                int temperature = 30;
                L3: for(; ; ){
                    temperature++;
                    System.out.print(temperature+", " );
                    if(temperature > 50) continue L2;
                }
            } while (humidity > 4);
        }
    }

    public static void main(String[] args) {
        int[][] list = {{1,13},{5,2},{2,2}};
        findMatrix(list, 2);
        cleaningSchedule();
        bunnyWithRabbit();
        checkLevels(1);
    }
}
