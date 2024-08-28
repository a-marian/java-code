package daily.agost;

public class Zebrator {
    private int x=23;
    public int hunt(){
        String message = " x is ";
        abstract class Stripes{
            private int x=0;
            public void print(){
                System.out.println(message+ Zebrator.this.x);
            }
        }
        var s = new Stripes(){};
        s.print();
        return x;
    }

    public static void main(String[] args) {
        new Zebrator().hunt();
    }
}
