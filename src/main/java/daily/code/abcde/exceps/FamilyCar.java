package abcde.exceps;

import java.io.Closeable;
import java.io.IOException;


public class FamilyCar {


    static class Door implements AutoCloseable {

        @Override
        public void close() throws Exception {

            System.out.print("D");
        }
    }

    static class Window implements Closeable {

        @Override
        public void close() throws IOException {
            System.out.print("W");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        var d = new Door();
        try(d; var w = new Window()){
            System.out.print("T");
        }catch (Exception e){
            System.out.print("E");
        }finally {
            System.out.print("F");
        }
    }
}
