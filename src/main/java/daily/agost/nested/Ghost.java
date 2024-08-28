package daily.agost.nested;

public class Ghost {

    public static void boo(){
        System.out.println("Not scared");
    }
    protected class Spirit{ // if this class was declared final, the code does not compile
        public void  boo(){
            System.out.println("Boo!!!");
        }
    }

    public static void main(String[] args) {
        var g = new Ghost().new Spirit(){};
        g.boo(); //Boo!!!
        new Ghost().boo(); // Not Scared
        //new Spirit().boo(); does not compile
        Ghost.boo(); // Not Scared
    }
}
