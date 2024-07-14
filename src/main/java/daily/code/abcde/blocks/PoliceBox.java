package abcde.blocks;

public class PoliceBox {

    String color;
    long age;
    public  PoliceBox(){
       this.color = "blue";
        this.age = 1200;
    }

    public static void main(String[] args) {
        var p = new PoliceBox();
        var q = new PoliceBox(); // q object keep the values initialized by constructor
        p.color = "green";
        p.age = 1500;
        p = q; // by this assignment p object takes the values from q object
        System.out.println("Q1= "+ q.color);
        System.out.println("Q2= "+ q.age);
        System.out.println("P1= "+ p.color);
        System.out.println("P2= "+ p.age);

    }
}
