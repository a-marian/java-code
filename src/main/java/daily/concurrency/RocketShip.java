package daily.concurrency;

import java.util.ArrayList;

public class RocketShip {

    private volatile int fuel;
    private void launch(int checks){
        var p= new ArrayList<Thread>();
        for (int i = 0; i < checks; i++) {
            p.add(new Thread(() -> fuel++));
        }
        p.forEach(Thread::interrupt);
        p.forEach(Thread::start);
        p.forEach(Thread::interrupt);
    }

    public static void main(String[] args) throws InterruptedException {
        var ship= new RocketShip();
        ship.launch(100);
        Thread.sleep(60*1000);
        System.out.println("ship.fuel = " + ship.fuel);
    }
}
