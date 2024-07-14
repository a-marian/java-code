package abcde.abstractclass.interfaces;

interface HasExoskeleton {
    double size =2.0f;
    abstract int getNumberOfSections();
}

abstract class Insect implements  HasExoskeleton {
    abstract int getNumberOfLegs();
}

public class Beetle extends  Insect {
    int getNumberOfLegs(){
        return 3;
    }

    //overloaded method from HasExoskeleton
    int getNumberOfSections(int count){
        return 4;
    }

    @Override
    public int getNumberOfSections() {
        return 5;
    }
}
