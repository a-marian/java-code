package daily.agost;

public interface BigKatty {
    abstract String getName();
  //  static int hunt(){ getName(); return 5;}  can not call a no static method
    default void climb(){ rest();}
   // private void roar(){ getName(); climb(); hunt();}
   // private static boolean sneak(){ roar(); return true;}
    private int rest(){ return 2;}



}
