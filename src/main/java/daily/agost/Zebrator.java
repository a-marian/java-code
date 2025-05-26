package daily.agost;

import java.util.WeakHashMap;

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

    public static void main(String[] args0) {
        WeakHashMap<String, String> weak = new WeakHashMap<>();
        new Zebrator().hunt();
    }
}
