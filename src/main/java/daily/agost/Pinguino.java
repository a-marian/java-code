package daily.agost;

interface Swim {
    default void perform(){
        System.out.println("Swim!");
    }
}

interface Dance {
    default void perform(){
        System.out.println("Dance!");
    }
}
public class Pinguino implements  Swim, Dance{
    protected int age = 3;
    public  Pinguino(){
        this.age=4;
    }

    public  Pinguino(int age){
        this();
    }
    @Override
    public void perform() {
        //Swim.super.perform();
        System.out.println("Smile!");
    }

    private  void doShow(){
        Swim.super.perform();
        Dance.super.perform();
    }

    public static void main(String[] args) {
        new Pinguino().doShow();
    }
}
