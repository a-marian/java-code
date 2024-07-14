package abcde.generics;

public class Handler {

    public static <T> void prepare(T t){
        System.out.println("generic method " + t);
    }

    public static <U extends Exception> void print(U u){
        System.out.println(u.getMessage());
    }

    public <T> Crate<T> ship(T t){
        System.out.println("generic method");
        return new Crate<T>();
    }

    public static void main(String[] args) {

        prepare(false);
        Handler.print(new IllegalArgumentException("illegal arg exception"));
        Handler.print(new Exception("exception"));
        Handler.<NullPointerException>print(new NullPointerException("null pointer exception") );
        Handler.<Exception>print(new ArithmeticException("arithmetic exception"));
      //  Handler.<ArithmeticException>print(new Exception("arithmetic exception")); NOT COMPILE
    }
}
