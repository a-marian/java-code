package abcde.methods.one;

import java.util.Date;

/** You can use access modifiers to allow access to all methods and not any instance variables*/
public class FinalVars {

    public String zooFriends(){
        final String name = "Harry and Potter";
        var size = 10;
        boolean wet;
        final Long song = 6L;

        if(size >100)size++;
        name.substring(0);
        wet = true; // effectively final
        return name;
    }
}
