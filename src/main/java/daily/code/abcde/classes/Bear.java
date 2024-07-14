package abcde.classes;

public class Bear {

    private String name;
    public Bear(String name){
        this.name = name;
    }

    private static void eat(){
        System.out.println("Bear is eating");
    }
    public  static void sneeze(){
        System.out.println("Bear is sneezing");
    }
    public void hibernate(){
        System.out.println("Bear is hibernating");
    }

    protected static void laugh(){
        System.out.println("Bear is laughing");
    }
}
