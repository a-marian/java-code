package abcde.classes;

import abcde.classes.Bear;

public class SunBear  extends Bear {
    public SunBear(String name) {
        super(name);
    }

    public static void sneeze(){
        System.out.println("Sun bear sneezes quietly");
    }

    public void hibernate(){
        System.out.println("Sun bear is going to sleep");
    }

    protected static void laugh(){
        System.out.println("Sun Bear is laughing");
    }
}
