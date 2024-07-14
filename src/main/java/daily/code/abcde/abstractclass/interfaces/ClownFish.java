package abcde.abstractclass.interfaces;

interface Aquatic {
    int getNumOfGills(int val);
}
public class ClownFish implements  Aquatic {

    String getNumOfGills(){
        return "4 gills";
    }
    public int getNumOfGills(int input){
        return 4;
    }

    public static void main(String[] args) {
        System.out.println(new ClownFish().getNumOfGills(-2));
    }
}
