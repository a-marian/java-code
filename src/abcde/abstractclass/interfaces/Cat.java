package abcde.abstractclass.interfaces;

 interface Walk{
    public default int getSpeed(){
        return 5;
    }
}

 interface Run{
    default int getSpeed(){
        return 10;
    }
}
public class Cat implements  Walk, Run{


    @Override
    public int getSpeed() {
        return Walk.super.getSpeed();
    }
}
